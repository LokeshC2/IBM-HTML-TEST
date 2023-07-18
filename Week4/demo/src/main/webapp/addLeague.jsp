<%@page
  import="java.util.List,java.util.ArrayList, com.exmaple.model.League, com.exmaple.factory.HibernateFactory, org.hibernate.Session, import="
  org.hibernate.Transaction" %>
  <!DOCTYPE html>

  <html>

  <head>
    <meta charset="ISO-8859-1">
    <title>Add League</title>
  </head>

  <body>

    <% List<String> list=(List<String>)request.getAttribute("ERROR")
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
          Integer.parseInt(yearString);
          }
          catch(NumberFormatException e)
          {
          list.add("Year must be a number");
          }
          }

          String season=request.getParameter("season");
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

          String title=request.getParameter("title");
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

          Sesssion session = HibernateFactory.getSession();
          Transaction tx = session.beginTransaction();
          session.save(league);
          tx.commit();
          session.close();
          //redirect to list_leagues.do
          response.sendRedirect("list_leagues.do");
          }
          else
          {
          //set attributes
          request.setAttribute("ERROR",list);
          //forward to add_league.jsp
          request.getRequestDispatcher("add_league.jsp").forward(request,response);
          }
          }
          %>

          <h1>Add League</h1>
          <% List<String> list=(List<String>)request.getAttribute("ERROR");

              if(list!=null)
              {
              for(String str:list)
              out.println("<font color='red'>"+str+"</font><br />");
              }
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