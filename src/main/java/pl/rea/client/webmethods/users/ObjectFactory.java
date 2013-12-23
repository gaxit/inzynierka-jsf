package pl.rea.client.webmethods.users;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the users package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUser_QNAME = new QName("users", "getUser");
    private final static QName _EditUser_QNAME = new QName("users", "editUser");
    private final static QName _IsUserLoggedResponse_QNAME = new QName("users", "isUserLoggedResponse");
    private final static QName _IsUserLogged_QNAME = new QName("users", "isUserLogged");
    private final static QName _LogOutResponse_QNAME = new QName("users", "logOutResponse");
    private final static QName _IsAnybodyLoggedResponse_QNAME = new QName("users", "isAnybodyLoggedResponse");
    private final static QName _CreateUserResponse_QNAME = new QName("users", "createUserResponse");
    private final static QName _LogInResponse_QNAME = new QName("users", "logInResponse");
    private final static QName _GetUserList_QNAME = new QName("users", "getUserList");
    private final static QName _IsAnybodyLogged_QNAME = new QName("users", "isAnybodyLogged");
    private final static QName _IsAdminLoggedResponse_QNAME = new QName("users", "isAdminLoggedResponse");
    private final static QName _CreateUser_QNAME = new QName("users", "createUser");
    private final static QName _EditUserResponse_QNAME = new QName("users", "editUserResponse");
    private final static QName _IsAdminLogged_QNAME = new QName("users", "isAdminLogged");
    private final static QName _DeleteUserResponse_QNAME = new QName("users", "deleteUserResponse");
    private final static QName _LogOut_QNAME = new QName("users", "logOut");
    private final static QName _DeleteUser_QNAME = new QName("users", "deleteUser");
    private final static QName _GetUserListResponse_QNAME = new QName("users", "getUserListResponse");
    private final static QName _GetUserResponse_QNAME = new QName("users", "getUserResponse");
    private final static QName _LogIn_QNAME = new QName("users", "logIn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: users
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditUser }
     * 
     */
    public EditUser createEditUser() {
        return new EditUser();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link IsUserLoggedResponse }
     * 
     */
    public IsUserLoggedResponse createIsUserLoggedResponse() {
        return new IsUserLoggedResponse();
    }

    /**
     * Create an instance of {@link IsUserLogged }
     * 
     */
    public IsUserLogged createIsUserLogged() {
        return new IsUserLogged();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link LogOutResponse }
     * 
     */
    public LogOutResponse createLogOutResponse() {
        return new LogOutResponse();
    }

    /**
     * Create an instance of {@link IsAnybodyLoggedResponse }
     * 
     */
    public IsAnybodyLoggedResponse createIsAnybodyLoggedResponse() {
        return new IsAnybodyLoggedResponse();
    }

    /**
     * Create an instance of {@link LogInResponse }
     * 
     */
    public LogInResponse createLogInResponse() {
        return new LogInResponse();
    }

    /**
     * Create an instance of {@link GetUserList }
     * 
     */
    public GetUserList createGetUserList() {
        return new GetUserList();
    }

    /**
     * Create an instance of {@link IsAnybodyLogged }
     * 
     */
    public IsAnybodyLogged createIsAnybodyLogged() {
        return new IsAnybodyLogged();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link EditUserResponse }
     * 
     */
    public EditUserResponse createEditUserResponse() {
        return new EditUserResponse();
    }

    /**
     * Create an instance of {@link IsAdminLoggedResponse }
     * 
     */
    public IsAdminLoggedResponse createIsAdminLoggedResponse() {
        return new IsAdminLoggedResponse();
    }

    /**
     * Create an instance of {@link IsAdminLogged }
     * 
     */
    public IsAdminLogged createIsAdminLogged() {
        return new IsAdminLogged();
    }

    /**
     * Create an instance of {@link GetUserListResponse }
     * 
     */
    public GetUserListResponse createGetUserListResponse() {
        return new GetUserListResponse();
    }

    /**
     * Create an instance of {@link LogOut }
     * 
     */
    public LogOut createLogOut() {
        return new LogOut();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link LogIn }
     * 
     */
    public LogIn createLogIn() {
        return new LogIn();
    }

    /**
     * Create an instance of {@link UserCanonical }
     * 
     */
    public UserCanonical createUserCanonical() {
        return new UserCanonical();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "editUser")
    public JAXBElement<EditUser> createEditUser(EditUser value) {
        return new JAXBElement<EditUser>(_EditUser_QNAME, EditUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserLoggedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isUserLoggedResponse")
    public JAXBElement<IsUserLoggedResponse> createIsUserLoggedResponse(IsUserLoggedResponse value) {
        return new JAXBElement<IsUserLoggedResponse>(_IsUserLoggedResponse_QNAME, IsUserLoggedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserLogged }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isUserLogged")
    public JAXBElement<IsUserLogged> createIsUserLogged(IsUserLogged value) {
        return new JAXBElement<IsUserLogged>(_IsUserLogged_QNAME, IsUserLogged.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "logOutResponse")
    public JAXBElement<LogOutResponse> createLogOutResponse(LogOutResponse value) {
        return new JAXBElement<LogOutResponse>(_LogOutResponse_QNAME, LogOutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAnybodyLoggedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isAnybodyLoggedResponse")
    public JAXBElement<IsAnybodyLoggedResponse> createIsAnybodyLoggedResponse(IsAnybodyLoggedResponse value) {
        return new JAXBElement<IsAnybodyLoggedResponse>(_IsAnybodyLoggedResponse_QNAME, IsAnybodyLoggedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "logInResponse")
    public JAXBElement<LogInResponse> createLogInResponse(LogInResponse value) {
        return new JAXBElement<LogInResponse>(_LogInResponse_QNAME, LogInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "getUserList")
    public JAXBElement<GetUserList> createGetUserList(GetUserList value) {
        return new JAXBElement<GetUserList>(_GetUserList_QNAME, GetUserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAnybodyLogged }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isAnybodyLogged")
    public JAXBElement<IsAnybodyLogged> createIsAnybodyLogged(IsAnybodyLogged value) {
        return new JAXBElement<IsAnybodyLogged>(_IsAnybodyLogged_QNAME, IsAnybodyLogged.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAdminLoggedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isAdminLoggedResponse")
    public JAXBElement<IsAdminLoggedResponse> createIsAdminLoggedResponse(IsAdminLoggedResponse value) {
        return new JAXBElement<IsAdminLoggedResponse>(_IsAdminLoggedResponse_QNAME, IsAdminLoggedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "editUserResponse")
    public JAXBElement<EditUserResponse> createEditUserResponse(EditUserResponse value) {
        return new JAXBElement<EditUserResponse>(_EditUserResponse_QNAME, EditUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAdminLogged }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "isAdminLogged")
    public JAXBElement<IsAdminLogged> createIsAdminLogged(IsAdminLogged value) {
        return new JAXBElement<IsAdminLogged>(_IsAdminLogged_QNAME, IsAdminLogged.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "logOut")
    public JAXBElement<LogOut> createLogOut(LogOut value) {
        return new JAXBElement<LogOut>(_LogOut_QNAME, LogOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "getUserListResponse")
    public JAXBElement<GetUserListResponse> createGetUserListResponse(GetUserListResponse value) {
        return new JAXBElement<GetUserListResponse>(_GetUserListResponse_QNAME, GetUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "users", name = "logIn")
    public JAXBElement<LogIn> createLogIn(LogIn value) {
        return new JAXBElement<LogIn>(_LogIn_QNAME, LogIn.class, null, value);
    }

}
