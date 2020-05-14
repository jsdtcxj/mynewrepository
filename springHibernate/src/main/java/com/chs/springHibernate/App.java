package com.chs.springHibernate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chs.springHibernate.dao.AddressDaoImpl;
import com.chs.springHibernate.entity.Address;
import com.chs.springHibernate.entity.Employee;
import com.chs.springHibernate.entity.EmployeeDtl;
import com.chs.springHibernate.service.AddressService;
import com.chs.springHibernate.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		EmployeeService service = context.getBean(EmployeeService.class);
		
		// create an employee record
        Employee employee = new Employee();
//        employee.setFirstName("XiaoMing");
//        employee.setLastName("Tang");
//        employee.setEmail("xiaoming.tang@abc.com");
//        service.add(employee);

		List employees = service.getEmployees();
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
		service.getEmployees();
		System.out.println("*******************HQL******************************");
		System.out.println(service.findById(1));// find by Id

		System.out.println("*******************QBC******************************");
		employee = service.findBy("firstName", "XiaoMing");
		System.out.println(employee);// find by Id

		System.out.println("*******************ManyToOne******************************");
//		employee = new Employee();
//		employee.setFirstName("Jimmy");
//		employee.setLastName("Liu");
//		employee.setEmail("jimmy.liu@abc.com");
//		Department department = new Department();
//		department.setDepName("Sales Dep");
//		employee.setDep(department);
//		service.add(employee);
		
		System.out.println("*******************ManyToOne******************************");
//		employee = new Employee();
//		employee.setFirstName("Thomas");
//		employee.setLastName("Wang");
//		employee.setEmail("thomas.wang@abc.com");
//		Project project = new Project();
//		project.setTitle("Payroll Costing");
//		Set<Project> projects = new HashSet<>();
//		projects.add(project);
//		employee.setProjects(projects);
//		service.add(employee);
		
		System.out.println("*******************Inheritance******************************");
		//Inheritance(strategy: single_table)
//		PersonService personService = context.getBean(PersonService.class);
//		Person person = new Person();
//		person.setName("Chris");
//		personService.add(person);
//		
//		ContractPerson contactPerson = new ContractPerson();
//		contactPerson.setName("Jackson");
//		contactPerson.setPerType("CONTRACT");
//		personService.add(contactPerson);
//		
//		PermanentPerson permanentPerson = new PermanentPerson();
//		permanentPerson.setName("Thomas");
//		permanentPerson.setPerType("PERMANENT");
//		personService.add(permanentPerson);
		
//		List<Person> persons = personService.findByExample("name", "JACKSON");
//		for(Person person : persons) {
//			System.out.println(person);
//		}
		
		//Inheritance(strategy: joined)
//		VehicleService vehicleService = context.getBean(VehicleService.class);
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("Car");
//		
//		TwoWheeler twoWheeler = new TwoWheeler();
//		twoWheeler.setVehicleName("Bike");
//		twoWheeler.setSteeringType("Bike steering hanlder");
//		
//		FourWheeler fourWheeler = new FourWheeler();
//		fourWheeler.setVehicleName("Alto");
//		fourWheeler.setSteeringType("Alto steering handler");
//		vehicleService.add(vehicle);
//		vehicleService.add(twoWheeler);
//		vehicleService.add(fourWheeler);
		
		System.out.println("******************* query ******************************");
		List<Employee> emps = service.getDepartment();//join fetch
		for(Employee emp : emps) {
			System.out.println(emp.getDep());
		}
		
		List<Object[]> emails = service.getEmails();//inner join
		for(Object[] objs : emails) {
			for(Object obj : objs) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}
		
		//select from multiple tables, and convert results to one POJO
		List<EmployeeDtl> employeeDtls = service.getEmployeeDtls();
		for(EmployeeDtl employeeDtl : employeeDtls) {
			System.out.println(employeeDtl);
		}
		
		System.out.println("******************* L2 Cache ******************************");
		AddressService addressService = context.getBean(AddressService.class);
		AddressDaoImpl dao = (AddressDaoImpl)addressService.getAddressDao();
		Statistics st = dao.getSessionFactory().getStatistics();
		st.setStatisticsEnabled(true);
		
		for(int i = 0; i < 5; i++) {
			addressService.get(27);//entity cache
			addressService.getAddresses();//query cache
		}
		
		addressService.update("country", "yaoji");//invalidate the cache
		addressService.getAddresses();
		addressService.getAddresses();
		
//		Cache cache = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.chs.springHibernate.entity.Address");
//		System.out.println(cache);
		
		System.out.println("CacheHitCount " + st.getSecondLevelCacheHitCount());
		System.out.println("CacheMissCount " + st.getSecondLevelCacheMissCount());
		System.out.println("CachePutCount " + st.getSecondLevelCachePutCount());
		System.out.println("******************* merge ******************************");
		Address address = addressService.get(27);
		address.setCountry("japan");
		addressService.update("Address", "tokoja");
		addressService.update(address);//override the change of address if it's merge method.
		
		System.out.println("******************* Named Query ******************************");
		List<Address> list = addressService.findByCountry("japan");
		for(Address a : list) {
			System.out.println(a);
		}
	
	}
}
