<%@page import="entity.Dimension"%>
<%@page import="drawing.SVGDrawingCarport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    SVGDrawingCarport svgDrawingCarport = new SVGDrawingCarport();
    
    String drawing = svgDrawingCarport.drawCarport(300, 600, new Dimension(800, 800));
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVGDrawingCarport</title>
    </head>
    <body>
        <h1>SVGDrawingCarport</h1>
        
        <%= drawing %>
    </body>
</html>
