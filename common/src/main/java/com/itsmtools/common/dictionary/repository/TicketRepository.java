package com.itsmtools.common.dictionary.repository;


import com.itsmtools.common.dictionary.model.Ticket;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import static org.hibernate.criterion.Restrictions.le;
import static org.hibernate.criterion.Restrictions.ge;
import static org.hibernate.criterion.Restrictions.lt;
import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.or;
import static org.hibernate.criterion.Restrictions.in;
import static org.hibernate.criterion.Restrictions.like;
import static org.hibernate.criterion.Restrictions.between;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class TicketRepository extends AbstractRepository<Ticket, Integer, String> {

    @Autowired
    private Session session;

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Ticket get(Integer id) {
        session.clear();
        return (Ticket) session.get(Ticket.class, id);
    }

    public void create(Ticket request) {
        if (request.getProgress() == null || request.getProgress() < 0) {
            request.setProgress(0);
        } else if (request.getProgress() > 100) {
            request.setProgress(100);
        }

        request.setAuthor(getPrincipal().getUser().getAccount());

        session.clear();
        session.save(request);
        session.flush();
    }

    public void update(Ticket ticket) {
        session.save(ticket);
        session.flush();
    }

    public void delete(Integer id) {
        Ticket instance = (Ticket) session.load(Ticket.class, id);

        if (instance != null) {
            session.clear();
            session.delete(instance);
            session.flush();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Ticket> list(Map<String, String> single, Map<String, List<String>> multi) {
        final Criteria query = session.createCriteria(Ticket.class);
        final List<SimpleExpression> progressCriteria = new ArrayList<>();

        if(single.containsKey("showComplete") && single.get("showComplete") != null && single.get("showComplete").equals("true")){
            progressCriteria.add(ge("progress", 100));
        }
        if(single.containsKey("showIncomplete") && single.get("showIncomplete") != null && single.get("showIncomplete").equals("true")){
            progressCriteria.add(lt("progress", 100));
        }
        if(progressCriteria.size() > 0){
            query.add(or(progressCriteria.toArray(new SimpleExpression[progressCriteria.size()])));
        }

        if (single.containsKey("anywhere")) {
            query.add(or(
                like("title", single.get("anywhere"), MatchMode.ANYWHERE),
                like("description", single.get("anywhere"), MatchMode.ANYWHERE)
            ));
        }

        if(single.containsKey("performerId")){
            query.add(eq("performer.id", Integer.valueOf(single.get("performerId"))));
        }

        if(single.containsKey("initiatorId")){
            query.createAlias("initiator", "initiator")
                .add(eq("initiator.id", Integer.valueOf(single.get("initiatorId"))));
        }

        if (single.containsKey("dateOpenFrom") && single.containsKey("dateOpenUntil")) {
            // if both
            query.add(between(
                "dateOpen",
                timestamp(single.get("dateOpenFrom")),
                timestamp(single.get("dateOpenUntil"))
            ));
        } else if (single.containsKey("dateOpenFrom")) {
            // if just from
            query.add(ge("dateOpen", timestamp(single.get("dateOpenFrom"))
            ));
        } else if (single.containsKey("dateOpenUntil")) {
            // if just until
            query.add(le("dateOpen", timestamp(single.get("dateOpenUntil"))));
        }

        if(multi.containsKey("levelIds") && multi.get("levelIds").size() > 0){
            query.add(in("supportLevel.id", multi.get("levelIds")
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList())));
        }

        query.addOrder(Order.desc("id"));
        session.clear();

        return query.list();
    }

    private Long timestamp(String date) {
        try{
            return format.parse(date).getTime();
        }catch (ParseException e){
            throw (RuntimeException) new RuntimeException(e).initCause(e);
        }
    }
}