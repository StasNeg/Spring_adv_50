package beans.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:55 PM
 */
@XmlRootElement(name = "rate")
@XmlAccessorType(XmlAccessType.FIELD)
public enum Rate {
    HIGH, MID, LOW
}
