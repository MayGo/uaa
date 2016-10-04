package org.cloudfoundry.identity.uaa.client.event;

import org.cloudfoundry.identity.uaa.audit.AuditEvent;
import org.cloudfoundry.identity.uaa.audit.AuditEventType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.ClientDetails;

public class AddSecretEvent extends AbstractClientAdminEvent {

    public AddSecretEvent(ClientDetails client, Authentication principal) {
        super(client, principal);
    }

    @Override
    public AuditEvent getAuditEvent() {
        return createAuditRecord(getClient().getClientId(), AuditEventType.SecretAddSuccess,
            getOrigin(getPrincipal()), "secret added");
    }
}