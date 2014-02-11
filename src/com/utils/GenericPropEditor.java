package com.utils;

 	import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

 
	public class GenericPropEditor<T> extends PropertyEditorSupport
	{
	    private T obj;
	    public GenericPropEditor (T obj){
	        super();
	        this.obj = obj;
	    }
	    public GenericPropEditor() {
	        super();
	    }

	    @Override
	    public String getAsText()
	    {
	        return obj.toString();

	    }

	    /*
	     * (non-Javadoc)
	     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	     */
	    @Override
	    public void setAsText(String text) throws IllegalArgumentException
	    {
	        ObjectMapper objMapper = new ObjectMapper();
	        try
	        {
	            if(text!=null){
	                obj = (T) objMapper.readValue(text, obj.getClass());
	            }
	           
	        }
	        catch (JsonParseException e)
	        {
	            e.printStackTrace();
	        }
	        catch (JsonMappingException e)
	        {
	        	e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	        	e.printStackTrace();
	        }
	        finally
	        {
	            setValue(obj);
	        }
	    }

	    /*
	     * (non-Javadoc)
	     * @see java.beans.PropertyEditorSupport#setValue(java.lang.Object)
	     */
	    @Override
	    public void setValue(Object value)
	    {
	        super.setValue(value);
	    }

	    }