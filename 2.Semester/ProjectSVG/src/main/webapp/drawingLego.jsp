<%@page import="drawing.SVGDrawingLego"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int width = 8;
    int length = 8;
    int height = 8;

    SVGDrawingLego svgDrawingLego = new SVGDrawingLego();

    String drawing = svgDrawingLego.drawLego(length, height);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVGDrawingLego</title>
    </head>
    <body>
        <h1>SVGDrawingLego</h1>

        <svg width="50%" viewBox="0 0 <%= length * 100 %> <%= height * 100 %>">
            <%= drawing %>
        </svg>

        <svg width="50%" viewBox="0 0 <%= length * 100 + 200 %> <%= height * 100 + 200 %>">
            <defs>
                <marker id="beginArrow"  markerWidth="9" markerHeight="9" refX="0" refY="4" orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000;" />
                </marker>
                <marker id="endArrow" markerWidth="9" markerHeight="9" refX="8" refY="4" orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>

            <line
                x1="100"
                y1="0"
                x2="100"
                y2="<%= height * 100 %>" 
                style="stroke:#006600;
                marker-start: url(#beginArrow);
                marker-end: url(#endArrow);" />
            
            <text
                x="140"
                y="<%= height * 100 / 2 %>"
                font-size="40px"
                text-anchor="middle"
                style="writing-mode: tb;">Height: <%= height %></text>

            <line
                x1="200" 
                y1="<%= height * 100 + 100 %>"
                x2="<%= length * 100 + 200 %>"
                y2="<%= height * 100 + 100 %>" 
                style="stroke:#006600;
                marker-start: url(#beginArrow);
                marker-end: url(#endArrow);"/>

            <text
                x="<%= length * 100 / 2 + 200 %>"
                y="<%= height * 100 + 80 %>"
                font-size="40px"
                text-anchor="middle">Width: <%= length %>
            </text>

            <svg x="200" y="0" width="<%= length * 100 %>" height="<%= height * 100 %>" viewBox="0 0 <%= length * 100 + 1 %> <%= height * 100 + 1 %>">
                <%= drawing %>
            </svg>
            
        </svg>
        
    </body>
</html>
