<html>

<%@include file="includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 

<div class="container">  
    <div class="panel panel-primary">
        <div class="panel-heading"> Please sign up </div>
        <div class="panel-body">
		      
		   <form:form modelAttribute="user">
			  <div class="form-group">
			    <form:label path="email">Email address</form:label>
			    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" />
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			    <form:errors path="email" cssClass="error" />
			  </div>
			  	  <div class="form-group">
			    <form:label path="name">Name</form:label>
			    <form:input path="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name" />
			     <form:errors path="name" cssClass="error" />
			    
			  </div>
			  <div class="form-group">
			    <form:label path="password">Password</form:label>
			    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
			    <form:errors path="password" cssClass="error" />
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
		  
		  </form:form>
        </div>
        
    </div>
</div>


 

  
  <%@include file="includes/footer.jsp" %>
  
  
