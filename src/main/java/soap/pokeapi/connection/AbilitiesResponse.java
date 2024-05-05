//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.04 a las 08:59:42 PM CDT 
//


package soap.pokeapi.connection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pokemonInfo" type="{http://connection.pokeapi.soap}pokemonInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pokemonInfo"
})
@XmlRootElement(name = "abilitiesResponse")
public class AbilitiesResponse {

    @XmlElement(required = true)
    protected PokemonInfo pokemonInfo;

    /**
     * Obtiene el valor de la propiedad pokemonInfo.
     * 
     * @return
     *     possible object is
     *     {@link PokemonInfo }
     *     
     */
    public PokemonInfo getPokemonInfo() {
        return pokemonInfo;
    }

    /**
     * Define el valor de la propiedad pokemonInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PokemonInfo }
     *     
     */
    public void setPokemonInfo(PokemonInfo value) {
        this.pokemonInfo = value;
    }

}
