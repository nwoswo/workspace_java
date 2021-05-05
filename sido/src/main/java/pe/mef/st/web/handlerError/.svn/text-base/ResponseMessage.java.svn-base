package pe.mef.st.web.handlerError;

import java.util.Date;

public class ResponseMessage {
  private int statusCode;
  private Date timestamp;
  private String message;
  private String description;

  public ResponseMessage(int statusCode, Date timestamp, String message, String description) {
    this.statusCode = statusCode;
    this.timestamp = timestamp;
    this.message = message;
    this.description = description;
  }
  
  public ResponseMessage( String message) {
	    this.statusCode = 200;
	    this.timestamp = new Date();
	    this.message = message;
	  }

  public int getStatusCode() {
    return statusCode;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }
}