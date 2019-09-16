package src.main.Model;

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
    
}
