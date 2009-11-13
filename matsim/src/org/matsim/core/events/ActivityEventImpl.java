/* *********************************************************************** *
 * project: org.matsim.*
 * ActEvent.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2007, 2008 by the members listed in the COPYING,  *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */

package org.matsim.core.events;

import java.util.Map;

import org.matsim.api.basic.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.population.Activity;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.api.experimental.events.ActivityEvent;
import org.matsim.core.population.ActivityImpl;

abstract class ActivityEventImpl extends PersonEventImpl implements ActivityEvent {

	public static final String ATTRIBUTE_LINK = "link";
	public static final String ATTRIBUTE_ACTTYPE = "actType";

	private final Id linkId;
	private final String acttype;

	private transient Link link;
	private transient Activity act;

	ActivityEventImpl(final double time, final Person agent, final Link link, final Activity act) {
		super(time, agent);
		this.act = act;
		this.link = link;
		this.linkId = link.getId();
		this.acttype = act.getType();
	}

	ActivityEventImpl(final double time, final Id agentId, final Id linkId, final String acttype) {
		super(time, agentId);
		this.linkId = linkId;
		this.acttype = acttype == null ? "" : acttype;
	}

	@Override
	public Map<String, String> getAttributes() {
		Map<String, String> attr = super.getAttributes();

		attr.put(ATTRIBUTE_LINK, this.linkId.toString());
		attr.put(ATTRIBUTE_ACTTYPE, this.acttype);
		return attr;
	}

	public String getActType() {
		return this.acttype;
	}

	/** @deprecated use getLinkId() */
	@Deprecated
	public Link getLink() {
		return this.link;
	}

	public Id getLinkId() {
		return this.linkId;
	}

	public ActivityImpl getAct() {
		return (ActivityImpl) this.act;
	}

}
