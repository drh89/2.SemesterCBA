<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVGDrawing</title>
        <style>
            .cirkler
            {
                opacity: 0.5;
            }
        </style>
    </head>
    <body>
        <h1>SVGDrawing</h1>

        <svg width="50%" viewbox="0 0 150 25" style="background:rgb(255,255,0);">
        <!--<svg class="svgdrawing" style="background:rgb(255,255,0);">-->
            <g>
                <circle cx="25" cy="25" r="25" fill="#FF0000" />
                <circle cx="75" cy="25" r="22.5" stroke="#000000" stroke-width="5" fill="#FF0000" />
                <circle cx="125" cy="25" r="20" stroke="#000000" stroke-width="10" stroke-dasharray="5,5" stroke-linecap="round" fill="#FF0000" style="opacity: 0.5;" />
            </g>
        </svg>
        
        <br />
        
        <svg width="50%" viewbox="0 0 100 100" style="background: gray">
            <svg x="40%" y="40%" width="20%" height="20%" viewbox="0 0 500 500">
                <rect width="100%" height="100%" fill="yellow" />
                <circle cx="50" cy="50" r="50" style="fill: red" />
                <circle cx="150" cy="50" r="50" style="fill: red" />
            </svg>
        </svg>

        <br />
        
        <svg width="50%" viewbox="0 0 500 500" style="background:rgb(150,150,255)">
        
            <defs>
                <lineargradient id="gradient1" x1="0%" y1="0%" x2="0%" y2="100%">
                    <stop offset="0%" stop-color="rgb(0,255,0)" stop-opacity="1" />
                    <stop offset="100%" stop-color="rgb(0,0,255)" stop-opacity="1" />
                </lineargradient>
                
                <marker id="beginArrow" markerWidth="9" markerHeight="9" refX="0" refY="4"  orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" fill="#000000" />
                </marker>
                <marker id="endArrow" markerWidth="9" markerHeight="9" refX="8" refY="4" orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" fill="#000000" />
                </marker>
            </defs>
            
            <text fill="#FF0000" font-size="60" font-family="Verdana" x="50%" y="50%">SVG</text>

            <ellipse cx="100" cy="100" rx="60" ry="80" fill="url(#gradient1)" />
            
            <polygon points="100,10 40,198 190,78 10,78 160,198" fill="lime" stroke="purple" stroke-width="5" fill-rule="evenodd" />
            
            <line x1="10" y1="10" x2="10" y2="490" style="stroke:#006600; marker-start: url(#beginArrow); marker-end: url(#endArrow);" />
    
            <%
                for(int circles = 0; circles <= 10; circles++)
                {
                    %>
                        <circle class="cirkler" cx="<%= ((circles * 50) + 25) %>" cy="475" r="25" stroke="black" stroke-width="5" fill="red" />
                    <%
                }   
            %>
            
        </svg>        
        
        <script>
            [...document.getElementsByClassName("svgdrawing")].forEach(function(svgelement){
                var bounding = svgelement.firstElementChild.getBoundingClientRect();
                
                svgelement.setAttribute("viewBox", "0 0 " + bounding.width + " " + bounding.height);  
            });
            
            [...document.getElementsByClassName("cirkler")].forEach(function(circleelement, index){
                circleelement.addEventListener("click", function(){
                    alert("Clicked number: " + (index + 1) + "!!!");
                });
            });
        </script>
    </body>
</html>