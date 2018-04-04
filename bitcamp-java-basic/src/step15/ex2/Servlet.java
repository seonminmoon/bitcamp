package step15.ex2;

public interface Servlet {
    void init();
    void service();
    void destroy();
    String getServletInfo();
    String getServletConfig();
}
