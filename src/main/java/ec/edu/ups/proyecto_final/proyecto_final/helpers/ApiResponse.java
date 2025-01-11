package ec.edu.ups.proyecto_final.proyecto_final.helpers;

public class ApiResponse<T> {
    private boolean ok;
    private String error;
    private T data;
    private int code;

    public ApiResponse(boolean ok, String error, T data, int code) {
        this.ok = ok;
        this.error = error;
        this.data = data;
        this.code = code;
    }

    // Getters y setters
    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
