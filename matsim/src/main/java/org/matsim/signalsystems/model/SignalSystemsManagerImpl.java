/* *********************************************************************** *
 * project: org.matsim.*
 * SignalSystemsManagerImpl
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2010 by the members listed in the COPYING,        *
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
package org.matsim.signalsystems.model;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.matsim.api.core.v01.Id;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.signalsystems.data.SignalsData;

/**
 * @author dgrether
 */
public class SignalSystemsManagerImpl implements SignalSystemsManager {

	private SortedMap<Id, SignalSystem> signalSystems = new TreeMap<Id, SignalSystem>();
	
	private AmberLogic amberLogic;

	private EventsManager eventsManager;
	
	@Override
	public EventsManager getEventsManager() {
		return this.eventsManager;
	}

	@Override
	public void setEventsManager(EventsManager events) {
		this.eventsManager = events;
	}

	
	@Override
	public void requestControlUpdate(double time_sec) {
		for (SignalSystem system : this.signalSystems.values()){
			system.updateState(time_sec);
		}
	}

	public AmberLogic getAmberLogic(){
		return this.amberLogic;
	}

	@Override
	public void addSignalSystem(SignalSystem system) {
		this.signalSystems.put(system.getId(), system);
	}

	@Override
	public void setAmberLogic(AmberLogic amberLogic) {
		this.amberLogic = amberLogic;
	}

	@Override
	public void resetModel(Integer iterationNumber) {
		//TODO 
	}

	@Override
	public Map<Id, SignalSystem> getSignalSystems() {
		return this.signalSystems;
	}

	@Override
	public SignalsData getSignalData() {
		// TODO Auto-generated method stub
		return null;
	}

}
