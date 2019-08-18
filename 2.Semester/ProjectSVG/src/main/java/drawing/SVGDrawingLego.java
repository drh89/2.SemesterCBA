package drawing;

public class SVGDrawingLego
{
    public String drawLego(int length, int height)
    {
        StringBuilder sb = new StringBuilder();
        
        for (int layer = 0; layer <= height; layer++)
        {
            sb.append(layer(length, layer));
        }
        
        return sb.toString();
    }

    private String layer(int length, int layer)
    {
        switch (layer % 4)
        {
            case 0:
                return layerRightward(length, layer, true);
            case 1:
                return layerRightward(length, layer, false);
            case 2:
                return layerLeftward(length, layer, true);
            case 3:
                return layerLeftward(length, layer, false);
        }
        
        return "";
    }

    private String layerRightward(int length, int yPos, boolean start)
    {
        length = length - 2;
        
        if (start)
        {
            return mainLayRightward(length, 0, yPos) + brick(2, length, yPos);
        }
        else
        {
            return brick(2, 0, yPos) + mainLayRightward(length, 2, yPos);
        }
    }

    private String layerLeftward(int length, int yPos, boolean start)
    {
        length = length - 2;
        
        if (start)
        {
            return mainLayLeftward(length, 0, yPos) + brick(2, length, yPos);
        }
        else
        {
            return brick(2, 0, yPos) + mainLayLeftward(length, 2, yPos);
        }
    }

    private String mainLayRightward(int length, int xPos, int yPos)
    {
        StringBuilder sb = new StringBuilder();
        
        while (length >= 4)
        {
            sb.append(brick(4, xPos, yPos));
            length = length - 4;
            xPos = xPos + 4;
        }
        if (length >= 2)
        {
            sb.append(brick(2, xPos, yPos));
            length = length - 2;
            xPos = xPos + 2;
        }
        if (length == 1)
        {
            sb.append(brick(1, xPos, yPos));
        }
        
        return sb.toString();
    }

    private String mainLayLeftward(int length, int xPos, int yPos)
    {
        StringBuilder sb = new StringBuilder();
        
        if ((length % 2) == 1)
        {
            sb.append(brick(1, xPos, yPos));
            length--;
            xPos++;
        }
        if (length % 4 == 2)
        {
            sb.append(brick(2, xPos, yPos));
            length = length - 2;
            xPos = xPos + 2;
        }
        while (length >= 4)
        {
            sb.append(brick(4, xPos, yPos));
            length = length - 4;
            xPos = xPos + 4;
        }
        
        return sb.toString();
    }

    private static final String[] BRICK_COL =
    {
        "none", "#5555FF",
        "#00DD00",
        "none",
        "#FF0000"
    };

    private String brick(int size, int xPos, int yPos)
    {
        String brick = "";
        
        brick += "<rect x='" + xPos * 100 + "' y='" + yPos * 100 + "' width='" + size * 100 + "' height='100'" + "style=\"stroke: #000000; fill: " + BRICK_COL[size] + "\"/>";
        brick += "<text x='" + (xPos * 100 + (size * 100) / 2) + "' y='" + (yPos * 100 + 50) + "' "+ "font-family=\"Verdana\" font-size=\"50px\"" + "text-anchor=\"middle\" alignment-baseline=\"middle\">" + size + "</text>\n";
        
        return brick;
    }
}