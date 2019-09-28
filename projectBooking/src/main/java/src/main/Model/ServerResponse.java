package src.main.Model;

import com.google.gson.Gson;

public class ServerResponse {
	private String content = "";
    private String status = "Success";
    
    public void setContent(String _content) 
    {
    	content=_content;
    }
    
    public void setStatus(String _status)
    {
    	status = _status;
    }
    
    public String getContent()
    {
    	Gson gson = new Gson();
    	
    	return gson.toJson(this);
    }
    
}
