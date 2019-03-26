<html>

<%@include file="includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<div class="container">  
    <div class="panel panel-primary">
        <div class="panel-heading"> Please sign in </div>
        <div class="panel-body">
		    <c:if test="${param.logout != null}">
				<div class="alert alert-success">
					You have been signed out!
				</div>
			</c:if>  
			
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					Fail to log in
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
						Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</c:if>
				</div>
			</c:if>
		   <form:form>
			  <div class="form-group">
			    <label for="email">Email address</label>
			    <input name="username" id="email" type="email" class="form-control" placeholder="Enter email" />
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			    
			  </div>
			  	 
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input name="password" id="password" type="password" class="form-control" placeholder="Password" />
			    
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
		  
		  </form:form>
        </div>
        
    </div>
</div>


 

  
  <%@include file="includes/footer.jsp" %>
  
  
