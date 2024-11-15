package beans;

import javax.faces.bean.*;

@ManagedBean(name = "testBean", eager = true)
@ApplicationScoped
public class TestBean {
    @ManagedProperty(value = "#{message}")
    private String message;
    public TestBean() {
        message = "Lolka";
        System.out.println("Starting HelloWorld...");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
