<%@page import="drawing.SVGDrawingFOG"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SVGDrawingFOG svgDrawingFOG = new SVGDrawingFOG(200,200,200);
    svgDrawingFOG.setAngles(30);
    
    String drawingTop = svgDrawingFOG.drawTop();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVGDrawingFOG</title>
    </head>
    <body>
        <h1>SVGDrawingFOG</h1>
        
        <svg width="50%" viewbox="0 0 100 100" style="background: gray">
            <svg x="20%" y="20%" width="80%" height="80%">
                <rect width="100%" height="100%" fill="purple" />
                <%= drawingTop %>                
            </svg>
        </svg>

    </body>
</html>
