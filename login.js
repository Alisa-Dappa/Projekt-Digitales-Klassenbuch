var config = {
  tenant: 'f8cdef31-a31e-4b4a-93e4-5f571e91255a',
  clientId: 'add8085c-a84e-4db7-9976-83622f1cc8cb',
  redirectUri: window.location.origin,
  postLogoutRedirectUri: window.location.origin,
  cacheLocation: 'localStorage'
};
var authContext = new AuthenticationContext(config);
var isCallback = authContext.isCallback(window.location.hash);
if (isCallback) {
  authContext.handleWindowCallback();
}
var user = authContext.getCachedUser();
if (!user) {
  authContext.login();
}
function getToken() {
  authContext.acquireToken('your_resource_id', function (error, token) {
    if (error || !token) {
      console.log('Error retrieving token: ', error);
    } else {
      // Use the token to authenticate the user
      console.log('Token: ', token);
    }
  });
}