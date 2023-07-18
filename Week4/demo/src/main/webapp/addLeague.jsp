<%@ page
  import="java.util.List, java.util.ArrayList, com.example.model.League, com.example.factory.HibernateFactory, org.hibernate.Session, org.hibernate.Transaction"
  %>
  <!DOCTYPE html>

  <html>

  <head>
    <meta charset="ISO-8859-1">
    <title>Add League</title>
  </head>

  <body>

    <% List<String> list=(List<String>)request.getAttribute("ERROR");
        String season = null;
        Integer year = null;
        String title = null;
        if(list==null || list.isEmpty())
        {

        //validate

        list=new ArrayList<String>();
          String yearString=request.getParameter("year");
          if(yearString==null || yearString.trim().isEmpty())
          {
          list.add("Year is required");
          }
          else
          {
          try
          {
          year = Integer.parseInt(yearString);
          }
          catch(NumberFormatException e)
          {
          list.add("Year must be a number");
          }
          }

          season=request.getParameter("season");
          if(season==null || season.trim().isEmpty())
          {
          list.add("Season is required");
          }
          else
          {
          String[] seasons= config.getInitParameter("seasons").split(",");
          boolean found=false;
          for(String str:seasons)
          {
          if(str.equals(season))
          {
          found=true;
          break;
          }
          }
          if(!found)
          {
          list.add("Season must be one of "+config.getInitParameter("seasons"));
          }
          }

          title=request.getParameter("title");
          if(title==null || title.trim().isEmpty())
          {
          list.add("Title is required");
          }

          if(list.isEmpty())
          {
          //add to database
          League league=new League();
          league.setYear(year);
          league.setSeason(request.getParameter("season"));
          league.setTitle(request.getParameter("title"));

          Session s = HibernateFactory.getSession();
          Transaction tx = s.beginTransaction();
          s.save(league);
          tx.commit();
          s.close();
          //redirect to list_leagues.do
          response.sendRedirect("listLeague.jsp");
          }
          else
          {
          //set attributes
          request.setAttribute("ERROR",list);
          request.getRequestDispatcher("addLeague.jsp").forward(request,response);
          }
          }
          %>

          <h1>Add League</h1>
          <% List<String> l2=(List<String>)request.getAttribute("ERROR");

              if(l2!=null && !l2.isEmpty())
              {
              {
              for(String str:list)
              out.println("<font color='red'>"+str+"</font><br />");
              }}
              %>
              <p>
                This form allows you to create a new soccer league.
              </p>

              <form action="addLeague.jsp" method="POST">
                Year: <input type="text" name=’year’ /> <br /><br />
                Season: <select name="season">
                  <% String[] seasons=config.getInitParameter("seasons").split(","); for(String str:seasons) {
                    out.println("<option value='"+str+"'>"+str+"</option>");}%>
                </select> <br /><br />
                Title: <input type='text' name="title" /> <br /><br />
                <input type="submit" value="Add League" />
              </form>
              <a href="index.jsp"><- Back to Home</a>
  </body>

  </html>