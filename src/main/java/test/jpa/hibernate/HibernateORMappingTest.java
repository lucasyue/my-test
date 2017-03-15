package test.jpa.hibernate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bstek.bdf2.core.model.DefaultUser;

public class HibernateORMappingTest {
    private static SessionFactory sessionFactory; 
    private static Configuration cfg;
    @BeforeClass 
    public static void beforeClass() { 
       // new SchemaExport(new Configuration().configure()).create(false, true);
    	Properties p=new Properties();
    	try {
			p.load(HibernateORMappingTest.class.getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	cfg=new Configuration().addProperties(p);
    	//cfg.addAnnotatedClass(NoticeFlow.class);
        cfg.addAnnotatedClass(DefaultUser.class);
        //cfg.addAnnotatedClass(LogInfo.class);
        sessionFactory = cfg.buildSessionFactory();
    } 
    @AfterClass 
    public static void afterClass() { 
        sessionFactory.close(); 
    } 
    
    @Test 
    public void testAccount() { 
        Session session = sessionFactory.openSession(); 
        //session.beginTransaction(); 
        // session.getTransaction().commit(); 
        //List<AccountExt> alist = session.createCriteria(AccountExt.class).list();
        //List<EntrustedLoansAccount>list = session.createCriteria(EntrustedLoansAccount.class).setFetchSize(10).setFirstResult(1).list();
        session.close(); 
    } 
    @Test
    public void testJoinColumn(){
    	Session session=sessionFactory.openSession();
    	String id="dd625fc4-12e5-4843-8ac8-ed4e9a2ec1ba";
    	//NoticeFlow ntf=(NoticeFlow) session.load(NoticeFlow.class, id);
//    	ntf.getAdministrator();
//    	List<String>list=new ArrayList<String>();
//    	list.add("0b4a2a9d-9d59-4c3d-9dd0-b44cb975b59f");
//    	list.add(id);
//    	List<NoticeFlow>ntFlows=session.createCriteria(NoticeFlow.class).add(Restrictions.in("id", list)).list();
//    	Assert.notNull(ntf);
//    	Assert.isTrue(ntf.getId().equals(id));
//    	System.out.println(ntf.getOperationManager());
//    	Assert.notNull(ntf.getOperationManagerUser());
    }
    @Test
    public void testSelectIn(){
    	TimeDebug td = new TimeDebug("debug");
    	td.debug("begin");
    	Session session=sessionFactory.openSession();
    	String id="'0172dc7c-a1b2-474a-8ea1-dc3642ce2375'";
    	String sql1="select * from log_log_info where id_";
    	td.debug(" 1...");
//    	session.createCriteria(LogInfo.class.getName()).add(Restrictions.eq("id", id)).list();
//    	td.debug(" 2...");
//    	session.createCriteria(LogInfo.class.getName()).add(Restrictions.in("id", Arrays.asList(id))).list();
//    	td.debug(" 3...");
//		session.createSQLQuery(sql1+"="+id);
//		td.debug(" 4...");
//		session.createSQLQuery(sql1+"in");
//		td.debug(" 5...");
//    	String ids="('0172dc7c-a1b2-474a-8ea1-dc3642ce2375','693cd180-8772-48ad-9c04-9ad162afd8d8','326bc93e-36e0-43b7-85bd-bc046121bf9b','6037d9fe-7ca3-4ea7-bb18-950f3cce32d9','dc7c4df0-a8ba-411b-88f9-3f4b003419e1','f367f26d-a2f4-4170-9b06-3a75ac6adb48','76e430d7-3477-45c5-946f-344013fd63e3','6a4d090b-9248-45d5-8dab-1d16e5bad2b9','c8f4d8c1-fe35-454c-8389-09b464280462','7d6baf99-909b-494e-a3dd-22dea2bc19c2','2cb825fb-6b88-4581-a2b4-8a2da237d9e3','7e3f49cb-7f64-4917-8d51-ad887f35d133','33f16d65-1358-457b-9fdf-4430a4be025a','e71c33be-68bc-4d5c-9974-7a2d7693277b','97db2c8c-e181-437e-b5db-219f8af27f87','fab2ad95-b066-4e66-9a95-7134f1dcd84a','8e07cb22-a3d0-4f32-9d23-2a60a44878c3','1a5af472-5dab-4eb6-a2d0-e747ecf56e6c','4192c163-9b12-44c3-bdfd-bcfb1b19e64f','64acdc69-eace-482f-95e3-81c54dd8ed47','8e991e3b-6586-4d99-8a21-703ee5576e2f','a919caad-4935-4d97-bdef-e62f812b67b3','5ae080af-c8fb-4b77-ac07-b949fdea6850','0b5f9da4-54be-434b-9a42-0ad47f4295b8','71e193d1-06c1-4a01-8cd5-38675b8f86ef','d17ffcfd-c88b-4d30-bb9b-7225f2a00d08','b3b34535-f7ef-4468-909a-30077fba6ce4','c5b35f0c-7665-4b22-9152-eb6555833b95','597bb1fe-8618-471d-b871-dbab56aadabc','fa86e1a4-f077-40f6-9c9e-5ab801a0c8b1','1e59a0fd-ffb4-43da-9737-cc6b1e06a662','9d1c8a93-520f-41ca-a4a4-e09ac5fb06cc','b6a44dfd-aa45-4edc-b658-847f11816743','7289fc10-4f3c-45a7-b1c7-90077dc2e03c','93b4382b-1831-44c2-9301-8cecdddca950','ae79a84a-2a5c-4ed2-bc4e-7282bdd92996','0ffbbd93-ec14-4a74-b8c1-be302170f16f','c9a3bdb0-3e4b-499a-b662-2092d5db5cdf','08d77574-3824-4d8a-ac98-deecbe2ac23d','8656eb0f-0689-4a60-ba58-758fcb4c33b1','74049815-9eb5-47a5-9da1-1ca5fe4ab18b','ba3952b6-5217-4947-aed5-b7161fec70d8','5239b0fd-9f71-4075-8841-c93893f516a6','5ddf9d4c-64fc-444f-bad0-ec2462254ebf','bcd0226b-ae1d-4cf1-8478-b82fbe4993a8','5f1e8c29-6531-4e84-9479-67366fdbeabc','7a69a6b0-2b9b-483b-9eb4-75466a364452','32f873b0-bee9-4abc-9a4a-3607f2c40627','fa9293ef-9b5a-4070-907c-cb381419d27c','23c693e5-8951-4ee8-9589-23c4c3e592b1','47e77013-1be6-4f1c-a4cd-1cdf91a0803b','7f597efc-70bc-4ad0-a0ee-065bdd8da4b0','86f39144-384c-4aae-adfb-5af23a13a4d1','f5da6b7d-5c87-4a52-ac04-41969a9c0643','fe0d5603-52cc-4d1e-af4b-5d8cfb6739d0','fa4d9817-5006-4755-be47-cac189cff14e','1f10bb5c-9c24-4073-8911-00f65960d6fe','59aa81ac-efbc-4a6b-8081-492540399f48','6feab8cd-b51b-4358-b416-67ebd031b020','44bcb2f9-9d6a-4a7d-919c-61784da87376','3fe188fa-43a1-45b8-bd6d-d0d13c4d8dec','45969f5a-006e-4c9c-99a2-59d58027d4bb','f22a3649-0a59-4658-bf9d-133ca7b64b15','7a763ef9-3614-471e-8177-a305f2541116','766d4433-c621-4344-80f6-2a287f8a8676','cbfb40f5-7c73-4712-8e8b-4225a4aef53b','a0b2863f-be66-4d05-a1d7-a9c7248a417a','e41a5243-52fe-4523-850c-7c78572046cb','180f2111-d453-4ef7-9589-25c34e4ae01a','3c8413fa-49de-44a5-9b36-d60570beb62e','3e9214b2-1bf3-42f6-9b97-c6c524d59628','5748f58e-6acc-43fa-976f-4341f69c49e3','dfaede11-a458-4c3c-b73c-e73c31a48d61','b720225c-082a-4622-8aa1-f3ebda7a45a8','1b2ac1c4-1b9d-45dd-8f3a-09a35f73e57b','d69b9a60-ca7e-4281-a7e5-dbb94e755caf','5f1e2f63-1c7d-48c3-90b7-fcb5497f54fd','f05d4af1-d526-4447-bbee-684c55a52d7d','22f17914-2b22-4259-b32f-e769e0cedad3','f211a86b-5fe2-4fae-9c67-835668054487','bdbf4471-ae84-43bf-9685-52534b2e288b','2c149f44-b16a-43f9-9ba7-752b6e2d6c5a','57f510d1-b7c9-4b62-a63d-a156787bf941','b42922a9-2a9f-4b9f-a10a-d3096c551210','858f46a6-c0f4-4b59-aecd-0dd2eff82ba4','83d3b335-17a5-417f-a787-6cdf64dadaab','01c8d36f-b025-4624-90ce-334bd36ffecd','244d85a9-e6ec-434c-bf4e-d55b44d6a9d6','0d88570b-6a2b-4674-b1d9-4f1cb61c163f','732fcd1c-ead0-4ade-9441-7e86a3171a54','2ae83bc6-d359-45dc-b091-9b702b8766a7','1e80eabd-4214-4f1b-9866-634b03c8bc58','27a5a379-cc94-415c-b3ce-466739b39bfb','614607ef-d948-4bdf-9eb5-e8d27147360d','ac699eeb-7641-46d0-bd0d-f3564b86a751','2e651189-026a-4828-86bf-e1aca1dd77be','f7f64159-b983-482d-86b8-33417401d054','1cf0d4d7-65ad-4cb1-8e2a-bacf9f75ff2e','8de320b2-9929-4ad3-8728-d66f210fe1f0','a9086b9b-91c9-4cb1-abb7-ddcf06144096','11b889e3-84d1-4927-94b1-5b5c267928ef','ff8e9813-73b3-45e6-93ba-cbda513eed86','99150bb7-89ab-4dfb-9b7f-abeccdb9af04','05b802cb-ba08-4d30-98f6-1d39a8536696','782c9010-941b-4c33-b4d9-5aa3bae0850e','31ae234f-54c3-4752-997f-3ab544f065e0','01489150-b096-4be1-8793-e3df6dd4733e','8958d72a-2e69-496f-b156-293e5b2264a3','f764d331-752a-4f31-88a5-b510b481bae3','7b1cbdf7-304e-44d6-93e1-ac79e2dd18dd','2e8f5ca7-7856-4c7b-8d9d-c78f0dad1d5d','3960ba2c-8e20-481e-b366-0eaa46649447','2dab722f-9d16-4ecc-a416-dfd3eed03890','5e724813-707a-42fe-8267-f17da0f28f55','7eec3128-ba28-42eb-ac05-030720770fe2','43bff1c2-707f-408e-901e-fabd864369fe','713b9993-19f2-4e46-86c4-f05b4ecfe1f2','dd34aae6-19f7-4344-9cc3-24fcfe3ec604','39e68c50-d3c2-46ce-813f-fdcb987551d9','2a70a35d-51cf-41e0-9c7d-4af3431faa77','39cd9cde-0822-40d2-bdff-367be0707cac','3e1a1d1a-d149-4b65-9b2e-95a8cf91edec','f4fbd2c9-1f9d-4bf0-b82d-ee2ba6ec448c','28fe567a-d4af-4171-8bf9-052847cfcdaf','1e28d02d-504b-4090-ae54-ab9629e4dc26','b1894b24-d805-44f4-88f5-19331747a5f0','2022fcca-2824-40b2-ba9c-a0904092fc9f','4192ebd9-aabc-40ba-a5c0-8dbcc680bdbe','e54dbb0a-77ba-4088-bcd8-d0c765ab20a3','83ee1981-9e30-4606-a92d-48368d5d990c','cead833a-7b73-4cf7-91f8-7b771c457f6e','d1f60edd-8e81-401f-a021-412db7c7ae08','e356530d-e701-4526-9f45-66f6bdb2de54','f04b7976-e7b9-4508-ad66-d4129204c72c','e00841d5-dba3-4a8c-b3a3-e7a5d4fc19e0','ca92676f-bad3-4aba-98b0-d147f0844a2d','bbd9c7a1-babc-49b1-aa65-5215dd585547','2f4eab43-8c38-445f-ae99-fab96851dc5c','7df5ebe7-0b1f-4c60-b312-af2b34a315c9','ea17d324-3fe8-4939-b339-705385ef0aaf','4909452b-69d5-4410-a794-85d9b5a0c04c','c743a137-3901-4e4f-8e3c-3c20bd38c869','5e70f037-4e92-4839-ac72-c8b071d9227e','ea75abdb-a22f-45b8-8660-8f5c74d7dfb6','11343a08-3f99-4616-bb07-b15d0f74481d','bf3613d5-de07-4bdc-a511-1c4c9b7018e6','45eccdc9-0162-42cb-bfac-394c73465955','841b4010-de91-41a5-b135-c544848e85c2','f102ab71-9b9c-4527-a634-baa154a6bcbb','76759760-6710-480f-978e-ab3bf197335a','25dab1ea-e1f3-4df0-8d62-a3b4d306fe17','698a2e7c-34e2-4cbe-87f2-431d053b28a3','4d7df3e7-f4b7-4c43-b6aa-a5c446d2f542','ea4ab7c3-0205-4d02-9e00-4cdc458a154b','4da9055c-a54c-4efe-9fac-1bcb2dba9d82','2a83cfc7-8107-416d-8c24-1a56928993ff','1228807c-7660-47a1-9b0f-2d9292e2ffd5','d291c68e-df65-4bfc-a6e5-1fbad917091e','5cd554ce-17c5-424d-9540-cf3e399f71ed','77bf2203-84af-4a46-b5f9-b18a6b1cad68','d2ae275e-5e9b-4e64-924c-46c5c04b296f','bf539c79-335f-434f-ac5a-6538bbf34e39','2913e5cc-0958-48b8-be19-40e64448f476','906775bd-16f0-4117-ada4-2ac16eeb329a','affe330d-f2bf-4581-b1cd-b36ec95ab660','f13ddaf2-814d-492a-b351-8d245d068676','ce532223-0021-491f-8f89-4b9e020b0a94','2b556d10-57ec-43dd-ac29-d2f075c9ee8b','24d63e24-53f6-4544-a90c-9fcc51b423bf','2df4d53c-2c27-438c-af73-fffa66f84a5c','e82c6f7e-d01c-47c0-91de-ce9228cae9e7','2f2a55ab-7a46-436a-9ee7-21d1a0a7838b','0f8af0e3-130e-404a-a141-45c696306593','c4ce70c9-c4a1-47c6-92e4-53494dfaaf8d','93f5f892-cd46-4f3b-99bd-962986c839c7','cb85064b-3166-436f-a74b-6237a852cdbe','415c5b0b-6822-46ef-af56-c347526b943e','2108cf2a-c38e-4f58-abc2-59a2bbab2b9f','64ce4252-166b-46e5-822b-e047ebece805','6ce5a0ef-10db-4b8c-be80-4c41b38bf4e0','c751652d-003f-448a-a8e1-dc6e8f39b3db','3fbb07f9-28ca-43ca-9270-346b93b6715a','89002eb2-2794-499f-b41c-015fc239dcf6','5e24a410-d07a-4ae1-95a7-30a25b466f20','56867811-1748-4cdd-8b6a-030060873605','244a5ed2-360c-49d4-be3f-7ea601ddc641','7a2f7fde-0927-4068-9bc8-7adea75a4ba5','80472621-f65b-46fe-a74a-493948057dc5','16a379a0-a831-41c1-a778-204db072924a','ac9ee0fb-59ee-4f15-91a0-ef56960f6f77','b3989fa2-05c5-4994-a7e7-486fa6bf9be7','922e6406-6f85-4c25-a12b-b9b122487682','8f37245c-3ec0-430d-ac56-fe221076076f','768d4205-401b-4683-adc0-36783c0999a8','6ddcda55-d2b8-44d0-9ee1-b8d9c4be8c9f','4aa05f9b-72e7-42a0-b3e9-bf540096cd8d','202ca74d-f84c-4555-beda-4d5f18e00855','a0819692-0c48-4e15-8c3b-b71ffdd5a504','ed6ee387-1768-48b5-adb0-49ba52d18eda','f90eba45-5a02-4cc8-96dd-8033b0924976','3cdd5fd4-e124-4921-abb2-e02089e92131','05434727-92b6-4562-887d-2c1c90c818d6','9f0539e6-32be-41fa-a7b5-5f4ae6e02abc','0e4191e5-c4ab-459e-9d13-b661c95b7be9','ae1bdb6d-43a1-455c-87f0-d0096b29fdae','f28ef941-ae1a-4519-aa58-db58b334445e','cd2f262c-d67b-417d-8a62-a0b256d57f05','983ed78c-8f68-4274-bab8-9d79ac2de293','7c9fc5a5-4a9a-4fd4-8204-87f125b6bf3b','8028dfd8-cdd3-4d96-b94d-d80db8624f26','fe308012-a53f-45bd-b2b9-767782ed4feb','b0267395-67b4-4a1b-b612-42c5c65ea714','f11b385b-a43c-4ffb-a3d8-e735b633b207','afd33e05-424c-4400-a938-4415867bed4a','6db44547-ebd6-4361-8e22-0438a3deb7ed','895bb92b-44c3-446b-b841-0e39a60416d5','8a47ed1c-c169-4a1d-8010-1dca4c4552f9','c4e52f69-65dd-419b-b7df-e719c38bd928','46c6d1be-2f32-4b1e-8210-4b709cbe2086','340bb444-1a50-4ecb-b11b-d3b2316ee2cc','d877eabf-c6c2-42c6-a34e-83fa4064d6ea','d92839e7-120c-42dd-b537-3eb26f196b88','a9b769ac-da3f-4297-ad7c-563c8e631750','ca6dd4ce-c83d-4a6c-947e-4931cc75aa2f','2b952aa9-6a58-4327-af77-a959ba64409e','6d0a0d2b-e510-4b82-844e-94ba39db2d59','450c321a-c234-45a2-bccc-294b498f70d2','ee46e0f0-8f5f-4566-9e9d-1967505cf9c0','d0c00b62-aba1-40df-99c3-4b8573a98f8d','32935836-b364-43a2-ba57-4e0d3bf9c40d','12ccd247-4559-48a0-8ded-0bd1e8d4a0a6','ad198e1b-11aa-45f0-9c7c-328a2430d74f','068fe150-6868-40a7-925d-42de555a25dd','c4f61cc3-2848-4a61-ac2e-853c7b351ebd','73cd50d8-5806-42d7-8aff-0a3d308bb647','7859ea44-43c8-4d6f-901e-40ca6f8d44ce','bdb0b309-b553-4c16-8804-88e246b849aa','3568eb7b-6295-440e-a787-f719c567c585','0286e8cd-f57e-4f38-99cf-3646ffd3bed1','4772ffa0-466a-48a7-a652-d9261c2ed81d','dc8ce42f-92df-41cc-91c9-f6870b09d945','56aa5f18-deef-4570-9ad2-0398d01961ee','72d0835b-e863-4e59-a4db-05c245a8f347','72cfdca9-a5b3-4351-9884-8fcb2db936d5','c1e94aff-9155-411f-91f3-6729c966ed4c','6787c7b3-ceca-4c40-a3af-0f1e43ec4640','a289ae32-dcf4-48d1-88ce-ecf1820aa1d2','c7a0f747-4586-470e-bf6b-ab17c113b469','a51d9c61-1d89-40ae-a24b-bcd05f74a1cb','f4c10a06-414c-438b-988d-5ac26419e6d9','78005207-9517-4b48-b490-a7b86ba48f91','91be3e1e-4c78-45f9-b9a4-f1858451ec3a','8c125eb6-2d0f-48d8-9c83-310634e69c94','9437d75a-9a5a-48ec-8c79-b94ebb0f3c0b','68898f93-8846-4efd-bfb3-0b585d410821','525b7603-47f6-4060-a007-f722853ac1ce','732bdd5b-18ac-4f6b-8596-e320ec69cffc','23a82f6c-dfde-4ee3-8690-2b5e4f10b609','189ac3ce-3385-45f0-8f27-f6f19cb52a94','792b487f-6b36-44fc-b683-64a21651b0f6','116671d1-b235-41f9-8e63-397c8baaa3ec','10a67611-cdb4-47f9-845f-def21717f807','76930248-8fd9-4c18-8eab-5c3741969957','106d3ac0-7d36-4066-9241-2b9067d79944','fbceb19b-659a-43fd-b82d-6b389ea0a6eb','b123052c-e26a-41c7-a448-3908e272b862','297ade72-7dce-4be9-b708-5ddcbbad7caf','d7dad462-c9fb-4134-8fa6-d449263488ac','29ed43a8-6e81-45a6-a5c5-db3dd9f08b3e','c84681b0-3072-4ca4-a440-1627a774027c','9ba0af4f-41f1-43f9-8996-51a7b254abb7','8a05a075-3b10-4df5-ac0c-e9fee2bfc8af','465fd841-ac5b-4465-9eea-93e99d9e1d30','3107dbcf-a250-4133-a057-2f962714d943','d7a22855-d08e-42b3-a196-e7c91be17096','9aac7f30-c1a3-42a2-8c16-dba3fe88d576','2f34a6dc-6f5c-4d83-baaa-d8fd5ac4512b','5c11248f-1592-49e0-8d04-c89f12198fa3','4181dcb5-8027-4c62-b7bf-f8fa4f6ac64d','0f1e4049-bcbe-40f1-baf5-9bb1d1939b68','c5726863-17df-4440-b9f4-3b089706273d','4df44cac-d6d8-43b9-afe8-a128f038ce1f','c1eee74b-a1b2-472d-b70e-14e6ccb45f65','3f96b0e0-85d4-4176-b855-c3dd93ceb25d','aad69a23-0297-40be-8e87-65ed0bc61802','d37696e3-dca4-44a9-9b42-f1e4f2ba9ae6','fa52b39b-1d31-46e6-8763-c73634e7c52c','6dfdffe2-7fd9-4c7b-a655-1e7f75498468','44ac8c9c-a755-4b05-83c5-3137168e3a8c','bdb5356c-8c23-40e0-a2d0-4883e36e2c2d','cbeca680-c1ce-409a-a7c0-2922fdd53577','cd506101-96e9-43ed-b37f-e8a9e9826535','3603bda8-c7f9-48ad-87f6-14ba9476e9f4','f624814a-a8be-494c-84b0-fdbceac87504','d1bc6642-7f00-4300-9102-2b491e6b5d54','db9d5f2f-010d-4ab8-b722-8fcffb5fff3a','e6ce581a-a543-48d1-b8e3-353d3b1643b3','5f914dea-b097-496b-a194-845d2d7cd8a0','86f12bef-842f-4c3d-b313-c4c14064c790','5ee10022-5386-45b6-a266-da7013da698f','a51a0f0d-0027-4375-8485-f2198a8eac29','93f3e3ee-70df-44a4-be3b-15edb69860ed','c3cd59be-2c03-439f-be2d-78b4d9d9ab81','f70cd8fd-c45e-40fb-b6fd-5e50befa412e','847b336e-4726-4dd3-bbb6-efd3123e94c3','eb17ad34-6210-4512-811e-aa5f30e4d898','01055778-7890-4c64-b381-ccf980757c80','03aff971-8d58-44f3-bf10-bf0630001d8b','7cd4c251-9139-483a-83ad-495b6af5520f','8698f6b5-7268-447a-b4ce-ab31bc406617','20602781-751a-4c0e-b185-f0bb0a4ffec6','6a15422c-2f05-4a3c-819f-7d691f75c71f','69e40fbd-7cd9-4b0c-b2a4-ab2a6022fce3','ca12d808-eeba-474f-bf4b-13273286dc3b','3b1a6475-fd5d-410f-8af4-f3910a233754','2f7475c0-056f-4990-8a75-dbdb6520fd49','f5a197ba-d0ec-4d60-a1ca-b84b6ca76aa5','7d17c041-0349-4e45-9a80-5eb2321d9aff','f382ebf2-1b72-4eb7-9b7d-42bc0686358a','e3747cf5-dd1e-41a7-9209-b7a35d0437c6','d8925711-80ec-4705-9713-11a37281727e','1f20546b-5ec5-43ba-beb6-1b6d761283e3','0787fc06-df03-4d3b-8a67-43f20be72519','f9ea1fc1-44e6-4f2f-a4f6-dee9873aba91','db509e33-d438-49f2-91c1-491ad9779d61','6e8b8ee4-149e-4f72-af63-031b9b58e339','007b433e-39c5-4699-a505-3769fe74dbd2','a33b4cd7-335b-4e43-b0d7-4695e91c85e4','e91db825-f7c4-4b83-bdd8-2f4e7754e90a','76d1e606-a6de-474d-8927-fec4f36eacf3','689a0de4-1cd6-4af4-9bc2-7322a712d0f5','cdd29be5-9f56-4e8f-9465-d47bb31da75c','1619defd-116b-4058-a58b-93dda20d1dfb','20ae49f6-d004-4643-a25c-88d1d20d0de3','6a3a8779-2bcf-4ca6-86d2-2c3fe52208e0','4ea5a6d8-30a2-44ba-ad0b-027f8a0f8535','0515743f-a2ea-4429-ac40-a8ef308157dc','2cb73fab-7f27-4f6a-a4ac-cb77238773de','fd67a42a-81c8-4894-832d-6b39cd373538','f944aac2-0027-4f71-8ab0-bd3b8a7b34dc','67aaa583-8db5-40e6-9473-f1ec1d9ae302','dd643e67-f67f-482d-9f70-1254e6ca5fca','1c06f3d4-d36b-4555-955f-8b89c962b636','c414f81e-7823-4adb-90bf-67435038893a','62d83868-e8a2-4114-a4e3-d58fa3cc1dc2','cb9129c2-4f99-460a-8c40-0f8d36c6eace','4bfcf6af-354e-474f-b513-b97c72039b58','59a90c5e-960c-473d-9b26-d72d734bb5f9','11a5ca13-c623-4b68-9752-4b062d4429a0','dfcb9ee1-5848-4c22-b39d-660fb0f3c606','fc5f0b08-028a-4118-a9a4-3e5f7aad7011','04627817-d05e-4e6f-aaa4-b608accade12','3a6e9ab9-192e-457a-906f-7282a5b4f31b','e578f2e1-6263-474c-8e34-7b98a0141183','23e2d925-ca47-4827-be4b-2d91f4202e01','29f3eff0-0b82-474e-b1e2-f19c7510d113','9ece50f1-3ca9-4a08-adea-68edd5a98e31','348b2cb5-301e-4f4b-90d5-1855b6e19802','6a53f9a4-cab1-4da2-b0c9-b5f9bee80b03','bae3e568-949f-4571-9e46-fbdebe2b19bc','5959e391-c823-4dcf-9aab-06c1f56ad527','741fe9b5-dbcc-4566-9eed-8af2bf616b14','b43a7ad8-5b34-40fc-8046-d06f19b4f79c','6a00a93f-78e2-4632-ab06-f6761bb405a4','0aa28e32-daa3-4db1-8af1-54b8e192c9b6','591ba093-8bc0-4b4e-9283-bc205b6960b3','f32e2d50-135c-4c7b-8428-a662646f59c0','57d7715d-6045-4884-8f0e-5e55d9c6b6b0','86c57fee-a97e-45cc-b08b-4fdd9ec5c9d5','c9b07955-07bf-43ab-8adc-79d3794ccd71','b4d67814-eb65-44df-b1c1-dd65e21c8ec2','c04a4a1d-8e8b-4bd5-ae9d-50a5dab39d6b','7c4e6501-01c0-422c-b435-853b409cb345','f28d08f4-b44e-4e21-ad1e-d91e94503601','7cf68864-86b3-432a-81e3-34476689a8a3','7a13871c-1548-43df-8048-04dfabccdc8a','ad4fab16-df07-4c21-a220-95a254d30947','4758238e-3b1a-4a8d-b581-2b9109d3bb3b','93eecc43-390b-4f2f-8965-e62311f3cb8a','f8dbf98b-f1b0-42b1-be87-bbfe77f31b3d','37635200-5e00-436a-a331-8bcb2bf2d899','036ac20d-074a-4ca1-b365-e63c6e418a0e','e54e96b8-148a-4026-86f8-f04340580eec','8a64b8a2-e834-427b-8328-9a1481392f59','3530c000-fb18-4015-8c93-28ca3f689443','8f9159f3-531b-4e6d-8709-86088e2d1722','87111749-31de-4509-9650-5b535f3acfbc','c81afb42-f197-4dc4-8402-f62ebc3c3d4f','35ae0ffc-58b7-468a-8ce1-9c2a4059daef','e8e8558d-40e9-4a74-bb48-082705b6d670','4cc679b1-217f-48bc-8acd-ea2144788945','5342872e-61eb-4e10-ac4b-84820941eeab','efb4781a-9a47-4c9a-b29b-aadac6d0213b','d54d55c2-e4c7-496e-bcd3-eed519fa93ce','35bcc7c4-e182-406b-9296-44c4702dd4c0','e7e01dad-97c2-49e6-b975-477b3d75d029','4636435f-a79d-46e6-8300-5cc9b5e6ac94','1faf8b82-ea71-4766-8f82-4f42a4ea1c6c','e77c13f8-d78f-4e60-be42-55766bfe493c','30ecc3a1-b31f-477b-b0a2-84eb2eaecee4','39197925-2f0e-431d-bc48-a09cdbf14a4c','92b9796d-dd1a-49c3-bac6-4e1f7a43f302','9e186616-22ee-46b8-b0f1-699ddba13bcf','e785ab1f-cd81-4b8d-94e1-c28ef0e32e8e','d30613a2-0377-4b54-8c1e-4d083befbe34','3cf8faf0-3ae3-4b7c-9d02-9d2f11d9aea5','547f0d16-989c-4fbe-aa4c-eaa4788e55c5','7149c92f-65f8-4c20-9048-c4bf355d20fa','771d1b27-fe9d-43f9-96b0-9b693e71eb69','615b1d0c-9514-402b-8727-e8b8f955022b','cbbf6427-a149-47c6-bd3c-482245b7a3f9','a0da1dc2-d9a9-4b21-8299-6d727766eaef','4272f660-1423-4c45-9419-3d5d8dec4769','ade302ed-25c6-4b99-a350-6c23162d4914','94c20fe0-b8af-4751-882f-1e812f7da7d9','bc9b339b-f8d6-4d97-9f84-7f8870d4d6cc','0bcc8abb-fd6c-468e-a887-c2ae1401e24a','1417b26e-8e0b-46ba-aed0-58c8b3996c6a','671b6910-5c82-42e8-83f1-336e0a744c61','7c7fc532-1cd2-47d7-ac76-4420fd86035b','6fb751e9-e8e1-4044-b030-7cc264b57020','88816b50-c9a0-4e25-8484-f574e8c3159d','8453d8ed-d0f2-49c9-8dba-21f0a29ae92f','3d420fb3-31b5-43dc-8ba4-b0f1214ebb85','c34c0b81-ab8b-4123-a782-076d153da9cc','55554c30-4881-48b1-93ac-c44f4e468464','f0072100-4bc9-4b8d-a56e-21c1052b0287','a8994565-d7dc-4061-9b76-256fcfff8df0','28c2384e-701e-48fb-b1e9-91aaa0dde17d','f7edb718-6bdd-4855-8181-d1067d64099f','91ca79d5-906d-4b55-a956-cff62418faf8','cf33c40d-1ae5-4927-b40a-18afe026b10f','a687c416-e42c-49af-b919-5136b78cd770','3cfd80a7-263f-4e90-88e5-8571b9915d56','f1e1e7a3-f59a-4e97-8dd6-fe829ee6fa91','551bb5f4-276a-4186-9b71-2e82da3c10de','ba113ee2-2de7-4ad9-b453-37e9eed49eb1','84a2d972-d75c-4f1c-ac46-e0ffca394770','1aa1cb22-3705-452e-b539-8c356a008e2d','5c4da395-1782-44ca-98e7-391b61d6dda7','48745760-7f06-4da2-8aa5-fa8f1ff90bfb','53689f4b-d97d-413f-b546-c1e9395255f4','d911e4aa-81d9-400d-b67a-a8b65c3acd65','3d6e4725-ba37-496c-9c42-96af6a8ea57e','69a90984-d498-456d-9098-8867e5696c88','622b1136-bd68-4c7d-8703-3f2878ae95ec','faa0a4f5-f240-4d34-86df-9a4083b9398f','4991d303-f2f0-418b-8f55-e8f78ed7f14d','b1fb911e-9687-49a5-98aa-b6e9ba408e98','21e247a1-1528-4055-8117-6795c792e3cb','9159b649-def5-460c-946e-0b09098e0e36','53d95e40-e872-4bd7-b150-9aa5f78705a7','8085655d-8d03-4985-95fa-9b2a6f06a6ce','6117de60-e496-4831-b359-4cfb7cd610be','9f8a83eb-42f8-4128-bc83-6906c6c867e9','fd31a279-f6cd-42f1-a327-f32c5e9c772e','e4bd8fbc-78d6-435d-87ae-24f53f3f85da','740836b1-12a2-4cf6-8ca0-dfd5739968ca','82886e21-e345-400b-95a4-c4325153f8c0','68b46a8c-0038-4a75-a9da-f8057d729658','019331f0-0b8c-419a-850b-4f5a6d333317','e9b1696f-a903-450b-abdb-7dceab216cd8','52b35205-b1a9-40d3-a319-17d444793aef','59a07140-5964-40bc-b520-9323f90d6f8e','5f697655-fb30-41c2-a097-6116d5ab32e2','f01bf8b0-0c6a-443f-9688-890943431118','d69aca45-bf02-4aa5-802f-2e0707659720','68847743-c545-455b-bff5-910fee44db07','e9203376-95c1-4d3c-b9dc-ab698bbf76d0','81ffb47c-fa8a-4186-b2de-ce6443ee5279','72385d8a-0685-446d-9242-26269b6ecf9d','64195c32-ae18-41a3-bf02-887eecf7b4f6','be16d185-c813-4c88-8294-2db55967d9ee','458a816b-c577-46a7-b8f6-bfc139c4b3ba','d2c4c0f2-8a59-4a56-8577-2dc316c6a1ae','8756c02d-9649-4ac4-839a-bdfae7e8b1f4','95ca6caf-5ac0-4c3a-a522-56ceeb7b7e6c','7268ac6f-876d-4fed-83ca-2c080d030b24','f605f3cf-baeb-4aa8-92f1-d026a27a578b','3c2fe07d-c776-4386-8afb-fc98255bf567','6c8ce8c8-c59b-44f9-8586-a4a329726684','5a82b845-af71-423f-8e82-8a28a497dc99','52135aa8-0390-4cf6-95f3-3dcbcb086ed9','084ac7a5-035d-4b1f-8137-8633e7db7eda','1da12dc2-3cff-4e33-9ac5-721b51ad2154','4109b5bf-90cd-48fd-ad34-07a1bae5bb75','4046a6b1-c4a7-48b0-9c1b-c58ca9bc09fd','d7fd379a-f327-42dc-93bd-ab44dbbcdb8f','df16ba7d-9091-46d9-89d7-f6d7659de612','ddbac368-d1be-46fe-941b-926d5a90e516','d2409591-eae0-4171-8c35-b183764944de','f3304736-3ca4-4841-9408-b19a46bdc2fb','71c35bbd-9d24-49d3-9ee7-18e121adadc0','d7f6ef41-2100-4793-aad7-455dcd79cf5c','2478372e-13d5-4831-8003-026abc015316','f13ad1c2-1ff7-40b3-8d9d-ad73223897eb','5db9ad0f-bd4d-454e-8863-2c6fd419a3a4','fce276b1-d3eb-4d34-ab4a-f804d7c155a2','fe3584da-63c4-431c-8d1e-3afa31eeacf5','8a6c652c-2f0d-43ba-80d2-a99552fa667c')";
//    	String hql="from "+LogInfo.class.getName()+" where id in "+ids;
//    	List<Product>pList = session.createQuery(hql).list();
//    	td.debug(" 6...");
//    	String sql="select * from log_log_info where id_ in ";
//    	session.createSQLQuery(sql+ids).list();
//    	td.debug(" 7...");
//    	String getIdSql="select id_ from log_log_info where operation_user_='yululu' and operation_date_ between to_date('2016/4/7','yyyy/MM/DD') and to_date('2016/12/8','yyyy/MM/DD')";
//    	session.createSQLQuery(sql+"("+getIdSql+")").list();
//    	td.debug(" 8...");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD");
//        try {
//			Date d1=sdf.parse("2016/4/7");
//			Date d2=sdf.parse("2016/12/8");
//			List<LogInfo>lList=session.createCriteria(LogInfo.class.getName()).add(Restrictions.eq("operationUser","yululu")).add(Restrictions.ge("operationDate", d1)).add(Restrictions.le("operationDate", d2)).list();
//			td.debug(" 9...");
//			List<String> pIds=session.createSQLQuery(getIdSql).list();
//			List<LogInfo>lList2=session.createCriteria(LogInfo.class.getName()).add(Restrictions.in("id",pIds)).list();
//			td.debug(" 10...");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
    }
    @Test 
    public void testLoad() { 
        Session session = sessionFactory.openSession(); 
    } 
    
    @Test 
    public void testSchemaUpdate() {
       new SchemaUpdate(cfg).execute(true, true);
    }
    
    
    public static void main(String[] args) { 
        beforeClass(); 
    } 
}
class TimeDebug{
	private long begin;
	private long total;
	private long time;
	private long last;
	private String debug;
	TimeDebug(){
		this.begin=new Date().getTime();
	}
	TimeDebug(String debug){
		this.begin=new Date().getTime();
		this.debug=debug;
	}
	public void debug(){
		this.debug("default","debug");
	}
	public void debug(String msg){
		this.debug(msg, this.debug);
	}
	public void debug(String msg,String debug){
		if("debug".equals(debug)){
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss SSS");
			StringBuffer str=new StringBuffer();
			str.append(sdf.format(new Date()));
			str.append(msg);
			str.append(" last ");
			str.append(last);
			str.append(",time ");
			this.time=new Date().getTime()-this.getBegin()-this.getTotal();
			str.append(time);
		    this.last=this.time;
		    this.total+=this.time;
		    str.append(",total ");
		    str.append(total);
		    System.out.println(str.toString());
		}
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getLast() {
		return last;
	}
	public void setLast(long last) {
		this.last = last;
	}
	public long getBegin() {
		return begin;
	}
	public void setBegin(long begin) {
		this.begin = begin;
	}
}