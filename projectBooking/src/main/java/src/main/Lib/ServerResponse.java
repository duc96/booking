package src.main.Lib;

import java.util.List;

import com.google.gson.Gson;

public class ServerResponse <T> {
	private int current = 0;
	private int rowCount = 15;
	private List<T> rows = null;
	private int total;
	
	private String content = "";
    private String status = "Success";
    
    /**
     * Set total result
     * @param _total
     */
    public void setTotal(int _total)
    {
    	total = _total;
    }
    
    /**
     * Set rows data
     * @param _rows
     */
    public void setRows(List <T> _rows)
    {
    	rows = _rows;
    }
    /**
     * Set row count
     * @param _rowCount
     */
    public void setRowCount(int _rowCount) 
    {
    	rowCount = _rowCount;
    }
    /**
     * Set current page
     * @param _current
     */
    public void setCurrent(int _current)
    {
    	current = _current;
    }
    
    /**
     * Set content of response
     * @param _content
     */
    public void setContent(String _content) 
    {
    	content=_content;
    }
    
    /**
     * Set status
     * @param _status
     */
    public void setStatus(String _status)
    {
    	status = _status;
    }
    
    /**
     * Response string
     * @return
     */
    public String encode()
    {
    	Gson gson = new Gson();
    	
    	return gson.toJson(this);
    }
    
}
