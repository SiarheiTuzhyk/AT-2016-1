<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="app.Person"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="app.Phone" %>
<%@ page import="app.StringConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Управление данными о телефонах</title>
</head>
<body>

<%
	HashMap<String,String> jsp_parameters = new HashMap<String,String>();
    Phone phone = new Phone();
    Person person = new Person();
	String error_message = "";
	if (request.getAttribute(StringConstants.JSP_PARAMETERS) != null)
	{
		jsp_parameters = (HashMap<String,String>)request.getAttribute(StringConstants.JSP_PARAMETERS);
	}
	if (request.getAttribute(StringConstants.PERSON) != null)
	{
        person = (Person)request.getAttribute(StringConstants.PERSON);
	}
    if (request.getAttribute(StringConstants.PHONE) != null)
    {
        phone = (Phone)request.getAttribute(StringConstants.PHONE);
    }
	error_message = jsp_parameters.get(StringConstants.ERROR_MESSAGE);
%>

<form action="<%=request.getContextPath()%>" method="post">
    <input type="hidden" name="id" value="<%=person.getId()%>"/>
    <input type="hidden" name="phone_id" value="<%=phone.getId()%>"/>

    <table align="center" border="1" width="70%">
    <%
    if ((error_message != null)&&(!error_message.equals("")))
    {
    %>
    <tr>
     	<td colspan="2" align="center"><span style="color:red"><%=error_message%></span></td>
    </tr>
    <%
    }
    %>
    <tr>
        <td colspan="2" align="center">Информация о телефоне владельца:
        <%=person.getSurname()+" "+person.getName()+" "+person.getMiddlename()%></td>
    </tr>
    <tr>
        <td>Номер:</td>
        <td><input type="text" name="number" value="<%=phone.getNumber()%>"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" name="<%=jsp_parameters.get(StringConstants.NEXT_ACTION)%>"
                   value="<%=jsp_parameters.get(StringConstants.NEXT_ACTION_LABEL)%>" />
            </br>
            <a href="<%=request.getContextPath()%>/?action=edit&id=<%=person.getId()%>">Вернуться к данным о человеке</a>
        </td>
    </tr> 
 </table>
 </form>
</body>
</html>