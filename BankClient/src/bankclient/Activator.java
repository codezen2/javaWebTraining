package bankclient;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sapient.service.ISer;
import com.sapient.service2.Iser2;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	private ServiceReference ref=null;
	public Activator() {
		
		
	}


	public void start(BundleContext context) throws Exception {
	System.out.println("Bank Client Started");
	ref=context.getServiceReference(ISer.class.getName());
	ISer ser=(ISer) context.getService(ref);
	System.out.println(ser.calcSimple(2000, 2, 3));
	ref=context.getServiceReference(Iser2.class.getName());
	Iser2 ser2=(Iser2) context.getService(ref);
	System.out.println(ser2.calcCompound(2000, 2, 3));
	
	}

	
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		System.out.println("Bank Client Stopped");

	}


}
