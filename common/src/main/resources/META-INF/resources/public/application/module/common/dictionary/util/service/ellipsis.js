export default () => {
  return (string, limit) => {
    limit = limit || 40;

    try {
      return string.length >= limit ? string.substring(0, limit) + ' ...' : string;
    } catch (e) {
      return "";
    }
  }
}