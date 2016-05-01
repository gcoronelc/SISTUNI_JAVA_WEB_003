<% if(session.getAttribute("usuario") == null){ %>
  <jsp:forward page="index.jsp"/>
<% } %>