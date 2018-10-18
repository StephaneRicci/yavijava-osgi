/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class ComputeResource extends ManagedEntity {
    public ComputeResource(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public ComputeResourceConfigInfo getConfigurationEx() {
        return (ComputeResourceConfigInfo) this.getCurrentProperty("configurationEx");
    }

    public Datastore[] getDatastores() {
        return getDatastores("datastore");
    }

    public Network[] getNetworks() {
        return getNetworks("network");
    }

    public HostSystem[] getHosts() {
        return getHosts("host");
    }

    public ResourcePool getResourcePool() {
        return (ResourcePool) this.getManagedObject("resourcePool");
    }

    public EnvironmentBrowser getEnvironmentBrowser() {
        return (EnvironmentBrowser) this.getManagedObject("environmentBrowser");
    }

    public ComputeResourceSummary getSummary() {
        return (ComputeResourceSummary) this.getCurrentProperty("summary");
    }

    public Task reconfigureComputeResource_Task(ComputeResourceConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference taskMOR = getVimService().reconfigureComputeResource_Task(getMOR(), spec, modify);
        return new Task(getServerConnection(), taskMOR);
    }

}
