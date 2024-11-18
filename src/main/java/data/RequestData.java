package data;

import org.json.JSONObject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "requestData", eager = true)
@SessionScoped
public class RequestData {
    private double x;
    private double y;
    private double r;
    private boolean flag;

    public RequestData() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("x", x);
        jsonData.put("y", y);
        jsonData.put("r", r);
        jsonData.put("flag", flag);
        return jsonData.toString();
    }
}
