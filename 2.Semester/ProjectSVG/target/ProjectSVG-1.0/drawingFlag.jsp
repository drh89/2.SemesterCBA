<%@page import="drawing.SVGDrawingFlag"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SVGDrawingFlag svgDrawingFlag = new SVGDrawingFlag();
    
    String drawing = svgDrawingFlag.drawFlag(0, 0, 90, 90, 30, "#ff0000");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVGDrawingFlag</title>
    </head>
    <body>
        <h1>SVGDrawingFlag</h1>
        
        <%= drawing %>
    </body>
</html>
