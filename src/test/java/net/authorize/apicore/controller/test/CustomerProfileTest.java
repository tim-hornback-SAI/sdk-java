package net.authorize.apicore.controller.test;

import java.util.List;

import junit.framework.Assert;
import net.authorize.apicore.contract.v1.CreateCustomerProfileRequest;
import net.authorize.apicore.contract.v1.CreateCustomerProfileResponse;
import net.authorize.apicore.contract.v1.CustomerPaymentProfileMaskedType;
import net.authorize.apicore.contract.v1.CustomerPaymentProfileType;
import net.authorize.apicore.contract.v1.CustomerProfileMaskedType;
import net.authorize.apicore.contract.v1.CustomerProfileType;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileRequest;
import net.authorize.apicore.contract.v1.DeleteCustomerProfileResponse;
import net.authorize.apicore.contract.v1.GetCustomerProfileRequest;
import net.authorize.apicore.contract.v1.GetCustomerProfileResponse;
import net.authorize.apicore.contract.v1.MerchantAuthenticationType;
import net.authorize.apicore.contract.v1.ValidationModeEnum;
import net.authorize.apicore.controller.CreateCustomerProfileController;
import net.authorize.apicore.controller.DeleteCustomerProfileController;
import net.authorize.apicore.controller.GetCustomerProfileController;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerProfileTest extends ApiCoreTestBase {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApiCoreTestBase.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ApiCoreTestBase.tearDownAfterClass();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testProcessCreateAndDeleteCustomerProfileRequest() {
		
		//create a new customer profile
		String customerProfileId = createCustomerProfile(cnpMerchantAuthenticationType, customerPaymentProfileOne, customerProfileType, refId);
		Assert.assertNotNull(customerProfileId);
		
		//delete the customer profile created earlier
		deleteCustomerProfile(cnpMerchantAuthenticationType, customerProfileId, refId);
	}

	static String createCustomerProfile(
			MerchantAuthenticationType merchantAuthenticationType, CustomerPaymentProfileType paymentProfileType,
			CustomerProfileType customerProfile, String referenceId) {

		CreateCustomerProfileRequest createRequest = new CreateCustomerProfileRequest();
		createRequest.setMerchantAuthentication( merchantAuthenticationType);
		createRequest.setRefId(referenceId);
		createRequest.setValidationMode(ValidationModeEnum.TEST_MODE);
		createRequest.setProfile( customerProfile);
		
		List<CustomerPaymentProfileType> paymentProfiles = createRequest.getProfile().getPaymentProfiles();
		paymentProfiles.clear();
		paymentProfiles.add( paymentProfileType);
		
		CreateCustomerProfileResponse createResponse = executeTestRequestWithSuccess(createRequest, CreateCustomerProfileController.class, environment);
		String customerProfileId = createResponse.getCustomerProfileId();

		return customerProfileId;
	}

	static void deleteCustomerProfile(MerchantAuthenticationType merchantAuthenticationType, String customerProfileId, String referenceId) {
		DeleteCustomerProfileRequest deleteRequest = new DeleteCustomerProfileRequest();
		deleteRequest.setMerchantAuthentication(merchantAuthenticationType);
		deleteRequest.setRefId( referenceId);
		deleteRequest.setCustomerProfileId( customerProfileId);
		
		DeleteCustomerProfileResponse deleteResponse = executeTestRequestWithSuccess(deleteRequest, DeleteCustomerProfileController.class, environment);
		Assert.assertNotNull(deleteResponse);
	}
	
	static List<CustomerPaymentProfileMaskedType> getCustomerPaymentProfile(
			MerchantAuthenticationType merchantAuthenticationType, String customerProfileId, String referenceId)
	{
		GetCustomerProfileRequest getRequest = new GetCustomerProfileRequest();
		getRequest.setMerchantAuthentication(merchantAuthenticationType);
		getRequest.setRefId( referenceId);
		getRequest.setCustomerProfileId( customerProfileId);
		
		GetCustomerProfileResponse getResponse = executeTestRequestWithSuccess(getRequest, GetCustomerProfileController.class, environment);
		CustomerProfileMaskedType customerProfileMaskedType = getResponse.getProfile();

		return customerProfileMaskedType.getPaymentProfiles() ;
	}
	
	static String getCustomerPaymentProfileId(
			MerchantAuthenticationType merchantAuthenticationType, String customerProfileId, String referenceId)
	{
		List<CustomerPaymentProfileMaskedType> customerPaymentProfiles = getCustomerPaymentProfile( merchantAuthenticationType, customerProfileId, referenceId);
		String paymentProfileId = null;
		if ( null != customerPaymentProfiles)
		{
			for( CustomerPaymentProfileMaskedType aProfile : customerPaymentProfiles)
			{
				paymentProfileId = aProfile.getCustomerPaymentProfileId();
			}
		}
		
		return paymentProfileId;
	}
}
