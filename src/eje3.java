import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import org.w3c.dom.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Element;

/**
 *
 * @author Juan
 * @descripcion Examen final <3
 */
public class eje3 {

    public static void main(String[] args) {
        File file = new File("cartita.xml");
        DocumentBuilder dBuilder;
        DocumentBuilderFactory dbFactory;
        Document doc = null;

        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Carta_desayunos");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            Element desayuno = doc.createElement("desayuno");
            Element name = doc.createElement("nombre");
            name.appendChild(doc.createTextNode("Gobres Belgas con fresas"));
            desayuno.appendChild(name);
            //NOMBRE ENCIMA
           // <precio>7.95</precio>
            Element precio = doc.createElement("precio");
            precio.appendChild(doc.createTextNode("7.95"));
            desayuno.appendChild(precio);
            //<descripcion>Ligeros gofres belgas cubiertos de fresas y nata
            //montada</descripcion>
            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode("Ligeros gofres belgas cubiertos de fresas y nata montada"));
            desayuno.appendChild(descripcion);
//<calorias>900</calorias>
            Element calorias = doc.createElement("calorias");
            calorias.appendChild(doc.createTextNode("900"));
            desayuno.appendChild(calorias);
            eElement.appendChild(desayuno);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("mensaje2.xml"));
            transformer.transform(source, result);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}