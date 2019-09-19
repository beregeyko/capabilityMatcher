package com.grid.selenium.matcher;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;

public class GridCapabilityMatcher extends DefaultCapabilityMatcher {

    @Override
    public boolean matches(Map<String, Object> nodeCapability, Map<String, Object> requestedCapability) {

        String nodeIP = "nodeIP";

        boolean basicChecks = super.matches(nodeCapability, requestedCapability);

        // If the request does not have the special capability, we return what the DefaultCapabilityMatcher returns
        if (!requestedCapability.containsKey(nodeIP)) {
            return basicChecks;
        }

        // We check that the node contains the special capability and if so, we try to match the capabilities
        if (nodeCapability.containsKey(nodeIP)) {
            return basicChecks && nodeCapability.get(nodeIP).equals(requestedCapability.get(nodeIP));
        }

        // If none of the previous matched, the node does not have the capabilities
        return false;
    }
}
