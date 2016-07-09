package osgi.enroute.examples.cm.ds;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Example Factory component configuration")
@interface ConfigAnnot {
	@AttributeDefinition(name = "Config Name", description = "Provides the name for this configuration")
	String name() default "ConfigName";
}

/**
 * I am using Eclipse Mars 2 with bnd tools 3.2.0
 * @author daghan
 *
 */

@Component(service = FactoryComponentWithMetaType.class)
@Designate(ocd = ConfigAnnot.class, factory = true)
public class FactoryComponentWithMetaType {
	@Activate
	private void activate(ConfigAnnot config) {
		System.out.println(this.getClass().getName() + config.name());
	}

}
