package groceryMain;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.exception.DuplicateRecordException;
import com.cg.gsm.service.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

import javax.sql.rowset.serial.SerialException;

public class groceryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		BookProductServiceImplements bookProductServiceImplements=new BookProductServiceImplements();
		ProductServiceImplements productServiceImplements=new ProductServiceImplements();
		UserServiceImplementation userServiceImplementation=new UserServiceImplementation();
		
		int choice;
		
		String firstName;
		String lastName;
		String loginId;
		String password;
		String mobileNo;
		String emailId;
		long roleId;
		long id;
		String createdBy="Admin";
		String modifiedBy="Admin";
		Timestamp createdDateTime= Timestamp.from(Instant.now());
		Timestamp modifiedDateTime=Timestamp.from(Instant.now());
		 
		String name;
		String code;
		String price;
		String description;
		String quantity;
		byte[] image;
		
		while(true)
		{
			System.out.println("** Grocery Shopping **");
			System.out.println("1.Registration \n 2.Sign In \n 3.Exit");
			System.out.println("Enter your choice"); 
			 choice=scan.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter First Name");
					firstName=scan.next();
					System.out.println("Enter Last Name");
					lastName=scan.next();
					scan.nextLine();
					System.out.println("Enter Login Id");
					loginId=scan.next();
					System.out.println("Enter Password");
					password=scan.next();
					System.out.println("Enter Mobile Number");
					mobileNo=scan.next();
					System.out.println("Enter Email Id");
					emailId=scan.next();
					System.out.println("Please select Role Id \n 1-Admin \n 2-Customer ");
					roleId=scan.nextLong();
					UserEntity userEntity=new UserEntity(createdBy,modifiedBy,createdDateTime,modifiedDateTime,firstName,lastName,loginId,password,
							mobileNo,emailId,roleId);
					System.out.println(userEntity);
				
				try {
					userServiceImplementation.add(userEntity);
				} catch (DuplicateRecordException exception) {
					
					exception.printStackTrace();
				}
					System.out.println("User Added Successfully.");
			
				break;
				
				
			case 2:	System.out.println("Enter your login details");
					System.out.println("Enter Login Id");
					loginId=scan.next();
					scan.nextLine();
					System.out.println("Enter Password");
					password=scan.nextLine();
					UserEntity userEntity1=userServiceImplementation.findByLogin(loginId);
					
					//System.out.println(userEntity1);
					//UserEntity userEntity1=userServiceImplementation.authenticate(userServiceImplementation.findByLogin(loginId));
					if(userEntity1.getLoginId().equals(loginId) && userEntity1.getPassword().equals(password))
					{
						System.out.println("Login Successful.");
						
						if(userEntity1.getRoleId()==1)
						{
							System.out.println("Select option for managing USER's or PRODUCTS\n1-USER\n2-PRODUCTS");
							choice=scan.nextInt();
							while(choice==1||choice==2)
							{
								if(choice==1)
								{
									System.out.println("** User Management **");
									System.out.println("1.Add user\n2.Delete user\n3.Search User");
									int option=scan.nextInt();
									while(option==1 || option==2 ||option==3)
									{
										
										
										switch(option)
										{
											
										case 1:	System.out.println("Enter First Name");
												firstName=scan.nextLine();
												scan.nextLine();
												System.out.println("Enter Last Name");
												lastName=scan.nextLine();
												System.out.println("Enter Login Id");
												loginId=scan.nextLine();
												System.out.println("Enter Password");
												password=scan.nextLine();
												System.out.println("Enter Mobile Number");
												mobileNo=scan.nextLine();
												System.out.println("Enter Email Id");
												emailId=scan.nextLine();
												System.out.println("Please select Role Id \n 1-Admin \n 2-Customer ");
												roleId=scan.nextLong();
												UserEntity adminUserEntity=new UserEntity(createdBy,modifiedBy,createdDateTime,modifiedDateTime,firstName,lastName,loginId,password,
														mobileNo,emailId,roleId);
															try {
												 userServiceImplementation.add(adminUserEntity);
												System.out.println("User Added Successfully.");
														} catch (DuplicateRecordException e) {
													e.getMessage();
												}
												break;

											
											
										case 2:	System.out.println("Enter the Id to be deleted");
												long deleteId=scan.nextLong();
												UserEntity userEntityDelete= userServiceImplementation.findByPK(deleteId);
												userServiceImplementation.delete(userEntityDelete);
												break;
											
										case 3:	System.out.println("Search User Options");
												System.out.println("1.Search user by loginId\n2.Search by Id(primary key)");
												int search=scan.nextInt();
												
													if(search==1)
													{
														System.out.println("Enter the login id to be searched");
														String searchLoginId=scan.nextLine();
														UserEntity searchUserByLogin= userServiceImplementation.findByLogin(searchLoginId);
														System.out.println(searchUserByLogin);
														

													}
													else if(search==2)
													{
														System.out.println("Enter the user Id");
														long searchUserId=scan.nextLong();
														UserEntity searchUserById= userServiceImplementation.findByPK(searchUserId);
														System.out.println(searchUserById);
														
													}
													break;									
										}
									}

								}
								else if(choice==2)
								{
									System.out.println("** Product Options**");
									System.out.println("1.Add Product\n2.Update Product\n3.Delete Product\n4.Search Product\n5.Get Image By Id");
									int option=scan.nextInt();
									
									if(option==1)
									{
										System.out.println("Enter Product Details");

										System.out.println("Enter name of product");
										name=scan.nextLine();
										System.out.println("Enter code of the product");
										code=scan.nextLine();
										System.out.println("Enter price of the product");
										price=scan.nextLine();
										System.out.println("Enter description of the product");
										description=scan.nextLine();
										System.out.println("Enter quantity of the product");
										quantity=scan.nextLine();
										//System.out.println("Provide the image of the product");
										image=new byte[10];
										
										createdBy="Admin";
										modifiedBy="Admin";
										createdDateTime= Timestamp.from(Instant.now());
										modifiedDateTime=Timestamp.from(Instant.now());
										
										ProductEntity productEntity=new ProductEntity(createdBy,modifiedBy,createdDateTime,modifiedDateTime,name,code,price,description,quantity,image);
										try {
											productServiceImplements.add(productEntity);
											System.out.println("Product addedd successfully");
										} catch (DuplicateRecordException e) {
											// TODO Auto-generated catch block
											e.getMessage();
										}		
									}
									else if(option==2)
									{
										System.out.println("Update the product details");
										
									}
									else if(option==3)
									{
										System.out.println("Enter the product name to be deleted");
										name=scan.nextLine();
										ProductEntity productEntity= productServiceImplements.findByName(name);
										//Here we can also use findByPk, findByCode 
										productServiceImplements.delete(productEntity);	
									}
									else if(option==4)
									{
										System.out.println("Search Product Options");
										System.out.println("1.Search by product name\n2.Search by Id(primary key)\n3.Search by product code");
										int search=scan.nextInt();
										while(true)
										{	
											if(search==1)
											{
												System.out.println("Enter the product name");
												name=scan.nextLine();
												ProductEntity productEntity= productServiceImplements.findByName(name);
												System.out.println(productEntity);

											}
											else if(search==2)
											{
												System.out.println("Enter the product  Id");
												id=scan.nextLong();
												ProductEntity productEntity= productServiceImplements.findByPk(id);
												System.out.println(productEntity);
											}
											else if(search==3)
											{
												System.out.println("Enter the product code");
												name=scan.nextLine();
												ProductEntity productEntity= productServiceImplements.findByName(name);
												System.out.println(productEntity);
											}
											else
											{
												System.out.println("Enter the correct option");
												search=scan.nextInt();
											}
										}
									}
									else if(option==5)
									{
										System.out.println("Enter the product id");
										id=scan.nextLong();
										try {
											Blob Image=productServiceImplements.getImageById(id);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.getMessage();
										}
									}

								}
								else
								{
									System.out.println("Please select correct choice");
									choice=scan.nextInt();
								}
							}
						}
						else if(userEntity1.getRoleId()==2)
						{
							System.out.println("Select the option\n1.Search for product\n2.Add Product to cart\n3.Delete Product ");
							int userOption=scan.nextInt();
							if(userOption==1)
							{
								System.out.println("Search Product Options");
								System.out.println("1.Search by product name\n2.Search by Id(primary key)\n3.Search by product code");
								int search=scan.nextInt();
								while(true)
								{	
									if(search==1)
									{
										System.out.println("Enter the product name");
										name=scan.nextLine();
										ProductEntity productEntity= productServiceImplements.findByName(name);
										System.out.println(productEntity);

									}
									else if(search==2)
									{
										System.out.println("Enter the product  Id");
										id=scan.nextLong();
										ProductEntity productEntity= productServiceImplements.findByPk(id);
										System.out.println(productEntity);
									}
									else if(search==3)
									{
										System.out.println("Enter the product code");
										name=scan.nextLine();
										ProductEntity productEntity= productServiceImplements.findByName(name);
										System.out.println(productEntity);
									}
									else
									{
										System.out.println("Enter the correct option");
										search=scan.nextInt();
									}
								}
							}
							else if(userOption==2)
							{
								System.out.println("Enter the product name to be added to the cart ");
								String productName=scan.nextLine();
								ProductEntity productEntity=productServiceImplements.findByName(productName);
								System.out.println(productEntity);
								long productId=Long.parseLong(productEntity.getCode());
								 String emailIdOfUser=userEntity1.getEmailId();
								 String mobileNoOfUser=userEntity1.getMobileNo();
								 System.out.println("Enter Country");
								 String country=scan.nextLine();
								 System.out.println("Enter State");
								 String state=scan.nextLine();
								 System.out.println("Enter District");
								 String district=scan.nextLine();
								 System.out.println("Enter Pincode");
								 String pincode=scan.nextLine();
								 System.out.println("Enter Address");
								 String address=scan.nextLine();
								 long userId=userEntity1.getId();
								System.out.println("Enter Quantity");
								String quantityOfProduct=scan.nextLine();
								String anmount=String.valueOf(Integer.parseInt(productEntity.getPrice())*Integer.parseInt(quantityOfProduct));
								 Date date=new Date();
								BookProductEntity bookProductEntity=new BookProductEntity(createdBy,modifiedBy,createdDateTime,modifiedDateTime,productId,productName,userEntity1.getFirstName(),emailIdOfUser,
										mobileNoOfUser,country,state,district,pincode,address,userId,quantityOfProduct,anmount,date);
								try {
									bookProductServiceImplements.add(bookProductEntity);
								} catch (DuplicateRecordException exception) {
									
									System.out.println(exception);
								}
								
		
								System.out.println("if you want to add another product press 1-(YES) else 2-(NO)");
								int bookAgain=scan.nextInt();
								
								while(bookAgain==1)
								{ 
									System.out.println("Enter the product name to be added to the cart ");
									productName=scan.nextLine();
									productEntity=productServiceImplements.findByName(productName);
									System.out.println(productEntity);
									System.out.println("Enter Quantity");
									quantityOfProduct=scan.nextLine();
									anmount=String.valueOf(Integer.parseInt(productEntity.getPrice())*Integer.parseInt(quantityOfProduct));
									date=new Date();
									bookProductEntity=new BookProductEntity(createdBy,modifiedBy,createdDateTime,modifiedDateTime,productId,productName,userEntity1.getFirstName(),emailIdOfUser,
											mobileNoOfUser,country,state,district,pincode,address,userId,quantityOfProduct,anmount,date);
									try {
										bookProductServiceImplements.add(bookProductEntity);
									} catch (DuplicateRecordException exception) {
										// TODO Auto-generated catch block
										System.out.println(exception);
									}
									
									System.out.println("if you want to add another product press 1-(YES) else 2-(NO)");
									bookAgain=scan.nextInt();
								}
							}
							else if(userOption==3)
							{
								System.out.println("Enter the product name to be delted from the cart");
								String productNameToBeDeleted=scan.nextLine();
								BookProductEntity bookProductEntity=bookProductServiceImplements.findByName(productNameToBeDeleted);
								bookProductServiceImplements.delete(bookProductEntity);
							}	
						}
					}
					else
					{
						System.out.println("User Id or Password is incorrect.");
					}	
				    break;
			case 3:System.out.println("Thank you. Please Shop Again.");
				   System.exit(0);
			
			}
		}

	}

}