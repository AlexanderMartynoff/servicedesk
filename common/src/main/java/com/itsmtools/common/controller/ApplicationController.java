package com.itsmtools.common.controller;


import com.itsmtools.common.controller.response.BaseResponse;
import com.itsmtools.common.controller.response.Response;


abstract public class ApplicationController {

    public Response jsonOk(){
        return new BaseResponse();
    }

    public Response jsonError(){
        return new BaseResponse();
    }

    public Response empty(){
        return null;
    }
}
