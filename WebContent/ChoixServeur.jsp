<%-- 
    Document   : ChoixServeur
    Created on : 28 mars 2022, 15:17:59
    Author     : U
--%>

<%@page import="model.Serveur"%>
<%@page import="model.Tablee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Choix serveur</title>
    </head>
    <body>
        <h1 class="text-center">Choix serveur</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group mb-3">
                        <form action="ListePlat" metod="GET">
                        <label class="input-group-text" for="inputGroupSelect01">Serveur</label>
                        <select class="form-select" id="inputGroupSelect01" name="idServeur">
                             <%
                             	Serveur[] s=(Serveur[])request.getAttribute("listeServeurs");
                                                             for(int i=0;i<s.length;i++){
                             %>
                            <option value="<%=s[i].getIdServeur()%>"><%=s[i].getNomServeur()%></option>
                           <%
                           	}
                           %>
                        </select>
                        <label class="input-group-text" for="tables">Table</label>
                        <select class="form-select" id="tables" name="idTable">
                             <%
                             	Tablee[] t=(Tablee[])request.getAttribute("listeTables");
                                                             for(int i=0;i<t.length;i++){
                             %>
                            <option value="<%=t[i].getIdtable()%>"><%= t[i].getNumerotable()  %></option>
                           <% }  %>
                        </select>
                        <input type="submit" value="valider" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
