package test.classloader;

import com.google.common.collect.Maps;

public class ReferencingClassA {  
  
        private final static String CLAZZ = ReferencingClassA.class.getName();  
  
        static {  
  
                System.out.println("Classloading of " + CLAZZ + " in progress..."  
                                + ClassloaderUtil.getCurrentClassloaderDetail());  
  
        }  
  
        public ReferencingClassA() {  
  
                System.out.println("Creating a new instance of "  
                                + ReferencingClassA.class.getName() + "...");  
                  
                Maps.newHashMap();  
  
        }  
  
        public void doSomething() {  
  
                // nothing to do...  
  
        }  
}  