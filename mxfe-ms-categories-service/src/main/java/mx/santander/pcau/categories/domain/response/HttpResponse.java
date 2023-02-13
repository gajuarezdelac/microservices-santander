package mx.santander.pcau.categories.domain.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HttpResponse {
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "America/Mexico_City")
    private Date timeStamp;
    
    private Map<String, Object> responseCode;
    private Map<String, Object> response;
    private Boolean ok;

    // Constructor never used. Can be (and should be) deleted
    public HttpResponse() {}
    
    public HttpResponse( Boolean ok,Map<String, Object> responseCode, Map<String, Object> response) {
        this.timeStamp = new Date();
        this.ok = ok;
        this.response = response;
        this.responseCode = responseCode;
    }
        
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public Map<String, Object> getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Map<String, Object> responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	
    

}

