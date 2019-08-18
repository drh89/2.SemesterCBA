package drawing;

import entity.Rectangle;

public class SVGDrawingFlag
{
    public String drawFlag(int x, int y, int width, int height, int space, String color)
    {
        Rectangle r1 = new Rectangle(x, y, height, width, color);
        Rectangle r2 = new Rectangle(x + width + space, y, height, width + space, color);
        Rectangle r3 = new Rectangle(x, y + height + space, height, width, color);
        Rectangle r4 = new Rectangle(x + width + space, y + height + space, height, width + space, color);

        StringBuilder sb = new StringBuilder("<svg width=\"127\" height=105 viewBox=\"0 0 " + (width + space + width + space) + " " + (height + space + height) + "\">");
        sb.append(getRect(r1));
        sb.append(getRect(r2));
        sb.append(getRect(r3));
        sb.append(getRect(r4));
        sb.append("</svg>");
        
        return sb.toString();
    }

    private String getRect(Rectangle rect)
    {
        String result = "<rect x=\"" + rect.x + "\" y=\"" + rect.y + "\" height=\"" + rect.length + "\" width=\"" + rect.width + "\"\n" + "style=\"stroke:#000000; fill: " + rect.color + "\"/>";
        
        return result;
    }
}