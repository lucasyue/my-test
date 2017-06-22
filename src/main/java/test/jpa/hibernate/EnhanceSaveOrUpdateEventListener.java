package test.jpa.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

public class EnhanceSaveOrUpdateEventListener extends
		DefaultSaveOrUpdateEventListener {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event)
			throws HibernateException {
		super.onSaveOrUpdate(event);
	}

	
}
