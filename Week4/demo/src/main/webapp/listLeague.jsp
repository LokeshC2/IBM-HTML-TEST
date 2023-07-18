<%@page import="java.util.List, java.util.ArrayList, com.exmaple.model.League, com.exmaple.factory.HibernateFactory" %>
  <!DOCTYPE html>

  <html>

  <head>
    <meta charset="ISO-8859-1">
    <title>List: League</title>
  </head>

  <body>
    <h1>All Leagues</h1>

    <table>
      <tr>
        <th>Year</th>
        <th>Season</th>
        <th>Title</th>
      </tr>
      <% TypedQuery<League> query=session.createQuery("from League");
        List<League> leagues=query.getResultList();
          for(League league:leagues)
          {
          %>
          <tr>
            <td>
              <%=league.getYear()%>
            </td>
            <td>
              <%=league.getSeason()%>
            </td>
            <td>
              <%=league.getTitle()%>
            </td>
          </tr>
          <% } %>
    </table>
    <a href="addLeague.jsp">Add League</a>
    <a href="index.jsp">Home</a>
  </body>

  </html>