// Importieren der MSAL-Bibliothek
import * as msal from '@azure/msal-browser';



// Konfigurieren von MSAL
const msalConfig = {
  auth: {
    clientId: 'your-client-id',
    authority: 'https://login.microsoftonline.com/your-tenant-id',
  },
  cache: {
    cacheLocation: 'sessionStorage',
  },
};
const msalInstance = new msal.PublicClientApplication(msalConfig);

// Anmelden des Benutzers
msalInstance.loginPopup()
  .then(() => {
    // Abrufen eines Zugriffstokens
    return msalInstance.acquireTokenSilent({
      scopes: ['user.read'],
    });
  })
  .then((accessTokenResponse) => {
    // Speichern des Tokens in der Session
    sessionStorage.setItem('accessToken', accessTokenResponse.accessToken);
  })
  .catch((error) => {
    console.log(error);
  });
