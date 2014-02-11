package com.utils;
 
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.iterators.ReverseListIterator;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * 
 * Provides utility methods and decorators for {@link Collection} instances. 
 * This class inherits all properties of CollectionUtils{@link CollectionUtils} and adds some convenience methods 
 * 
 */
@SuppressWarnings("unchecked")
public class CollectionUtilsExt extends CollectionUtils {
	 /** logger */
	 private static Log log = LogFactory.getLog(CollectionUtilsExt.class);
	 /**
	  * Returns the Equal Predicate based on beanPropertyName and value
	  * 
	  * @param beanPropertyName
	  *            ( Property of ValueObject which not null (or) empty)
	  * @param value
	  * @return
	  */
	 private static BeanPredicate getEqualPredicate(String beanPropertyName, Object value) {
	  //assertNotNull("BeanPropertyName cannot not be null", beanPropertyName);
	  EqualPredicate nameEqlPredicate = new EqualPredicate(value);
	  BeanPredicate beanPredicate = new BeanPredicate(beanPropertyName, nameEqlPredicate);
	  return beanPredicate;
	 }
	 /**
	  * Converts the valueObject to Map whose key is propertyName and value as corresponding value for
	  * PropertyName
	  * 
	  * @param beanObject
	  * @return
	  */
	 public static Map<String, Object> beanToMap(Object beanObject) {
	  return new BeanMap(beanObject);
	 }
	 /**
	  * Converts the List of Maps based on beanPropertyName <br>
	  * For example if passed List of User's and initials as beanPropertyName it returns the map whose key is
	  * initial and corresponding value is ValueObject <br>
	  * <code>listToMap(collection,"initials");</code>
	  * 
	  * @param <T>
	  * @param collection
	  *            - Collection of ValueObject
	  * @param beanPropertyName
	  *            - property of valueObject
	  * @return
	  * @throws ImproperUsageException
	  */
	 public static <T> Map<String, T> listToMap(Collection<T> inputCollection, String beanPropertyName) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  Map<String, T> map = new HashMap<String, T>(inputCollection.size());
	  for (T t : inputCollection) {
	   try {
	    map.put(BeanUtils.getSimpleProperty(t, beanPropertyName), t);
	   }
	   catch (Exception e) {
	    log.error("Exception in CollectionUtilsExt.listToMap", e);
	   // throw new ImproperUsageException("Exception in CollectionUtilsExt.listToMap", e);
	   }
	  }
	  return map;
	 }
	 /**
	  * Returns the ValueObject whose beanPropertyName is least <br>
	  * For Ex : <code>min(list,"salary")</code> ==> Returns the valueObject whose salary is least <br>
	  * If more than one valueObject having least salary then <code>min()</code> will return first matching
	  * valueObject from collection passed @
	  * 
	  * @param <T>
	  * @param collection
	  *            - List of ValueObjects
	  * @param beanPropertyName
	  * @param nullsAreHigh
	  *            a <code>true</code> value indicates that <code>null</code> should be compared as higher than
	  *            a non-<code>null</code> object. A <code>false</code> value indicates that <code>null</code>
	  *            should be compared as lower than a non-<code>null</code> object.
	  * @return
	  */
	 public static <T> T min(Collection<T> inputCollection, String beanPropertyName, boolean nullsAreHigh) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  Comparator<T> nullComparator = new NullComparator(nullsAreHigh);
	  Comparator<T> beanComparator = new BeanComparator(beanPropertyName, nullComparator);
	  T selectedObject = Collections.min(inputCollection, beanComparator);
	  return selectedObject;
	 }
	 /**
	  * Returns the ValueObject whose beanPropertyName is greatest For Ex : max(list,"salary") ==> Returns the
	  * valueObject whose salary is greater
	  * 
	  * @param <T>
	  * @param collection
	  * @param beanPropertyName
	  * @param nullsAreHigh
	  *            a <code>true</code> value indicates that <code>null</code> should be compared as higher than
	  *            a non-<code>null</code> object. A <code>false</code> value indicates that <code>null</code>
	  *            should be compared as lower than a non-<code>null</code> object.
	  * @return
	  */
	 public static <T> T max(Collection<T> inputCollection, String beanPropertyName, boolean nullsAreHigh) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  Comparator<T> nullComparator = new NullComparator(nullsAreHigh);
	  Comparator<T> beanComparator = new BeanComparator(beanPropertyName, nullComparator);
	  T selectedObject = Collections.max(inputCollection, beanComparator);
	  return selectedObject;
	 }
	 /**
	  * Sorts the List of ValueObjects based on beanPropertyName array
	  * 
	  * @param list
	  * @param beanPropertyNames
	  * @param isAscending
	  *            - sorts in Ascending if true , else descending
	  */
	 public static void sortCollection(List<?> list, boolean isAscending, String... beanPropertyNames) {
	  //assertNotNull("Collection cannot be null ", list);
	  /* NullComparator should be passed as isAscending ,Since null values needs to handled in dif way */
	  Comparator<Object> nullComparator = new NullComparator(isAscending);
	  Collection<Comparator<Object>> beanComparatorCollection = new ArrayList<Comparator<Object>>(
	    beanPropertyNames.length);
	  for (String beanPropertyName : beanPropertyNames) {
	   beanComparatorCollection.add(new BeanComparator(beanPropertyName, nullComparator));
	  }
	  Comparator<Object> finalComparator = ComparatorUtils.chainedComparator(beanComparatorCollection);
	  if (!isAscending) {
	   finalComparator = new ReverseComparator(finalComparator);
	  }
	  Collections.sort(list, finalComparator);
	 }
	 /**
	  * Returns the Value Object from List based on beanPropertyName and beanPropertyValue For Example
	  * selectObjectFromCollection(list,"firstName","yahoo") ==> Returns Value Object whose firstname is Yahoo
	  * If more than one valueObject exist for given criteria , it picks first matching one
	  * 
	  * @param <T>
	  * @param list
	  * @param beanPropertyName
	  * @param beanPropertyValue
	  * @return
	  */
	 public static <T> T selectFilteredObject(Collection<T> inputCollection, String beanPropertyName,
	   Object beanPropertyValue) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  BeanPredicate beanPredicate = null;
	  if (beanPropertyValue != null) {
	   beanPredicate = getEqualPredicate(beanPropertyName, beanPropertyValue);
	  }
	  else {
	   beanPredicate = new BeanPredicate(beanPropertyName, PredicateUtils.nullPredicate());
	  }
	  T selectedObject = (T) find(inputCollection, beanPredicate);
	  return selectedObject;
	 }
	 /**
	  * Returns the list of valueObjects whose valueObjects property having value value Example if
	  * beanPropertyName is "initials" and value is "GAGO" it returns the list of ValueObjects whose initials are
	  * "GAGO"
	  * 
	  * @param <T>
	  * @param list
	  * @param beanPropertyName
	  *            - Property Name of Value Object
	  * @param beanPropertyValue
	  *            - Value corresponding to beanPropertyName
	  * @return
	  */
	 public static <T> Collection<T> selectFilteredCollection(Collection<T> inputCollection,
	   String beanPropertyName, Object beanPropertyValue) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  BeanPredicate beanPredicate = getEqualPredicate(beanPropertyName, beanPropertyValue);
	  Collection<T> selectedList = select(inputCollection, beanPredicate);
	  return selectedList;
	 }
	 /**
	  * Convenience method which takes custom Predicate
	  * 
	  * @param <T>
	  * @param list
	  * @param customPredicate
	  * @return
	  */
	 public static <T> Collection<T> selectFilteredCollection(Collection<T> inputCollection,
	   Predicate customPredicate) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  Collection<T> selectedList = select(inputCollection, customPredicate);
	  return selectedList;
	 }
	 /**
	  * Selects from the collection whose beanPropertyName and beanPropertyValue For Ex we can select User
	  * whose firstname = 'smith' and lastname='john' we pass firstname and lastname in beanPropertyName[] we
	  * pass smith and john in beanPropertyNamevalue[]
	  * 
	  * @param <T>
	  * @param list
	  * @param beanPropertyNames
	  *            - String array of bean properties names
	  * @param beanPropertyValues
	  *            - Object array of values corresponding to bean properties in beanPropertyName
	  * @return
	  */
	 public static <T> Collection<T> selectFilteredCollection(Collection<T> inputCollection,
	   String[] beanPropertyNames, Object[] beanPropertyValues) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  Collection<T> selectedList = inputCollection;
	  if (!ArrayUtils.isEmpty(beanPropertyNames) && !ArrayUtils.isEmpty(beanPropertyValues)) {
	   //assertEquals("Length of beanPropertyNames and beanPropertyValues are mismatching ", beanPropertyNames.length, beanPropertyValues.length);
	   Predicate[] predicateArray = new Predicate[beanPropertyNames.length];
	   for (int i = 0; i < beanPropertyNames.length; i++) {
	    if (beanPropertyValues[i] != null) {
	     predicateArray[i] = getEqualPredicate(beanPropertyNames[i], beanPropertyValues[i]);
	    }
	    else {
	     predicateArray[i] = new BeanPredicate(beanPropertyNames[i], PredicateUtils.nullPredicate());
	    }
	   }
	   selectedList = select(inputCollection, PredicateUtils.allPredicate(predicateArray));
	  }
	  return selectedList;
	 }
	 /**
	  * Returns the list of valueObjects whose valueObjects property having value value Example if
	  * beanPropertyName is "initials" and value is "GAGO" it returns the list of ValueObjects whose intials are
	  * <b>NOT</b> "GAGO"
	  * 
	  * @param <T>
	  * @param list
	  * @param beanPropertyName
	  *            - Property Name of Value Object
	  * @param beanPropertyValue
	  *            - Value of
	  * @return
	  */
	 public static <T> Collection<T> selectRejectedCollection(Collection<T> inputCollection,
	   String beanPropertyName, Object beanPropertyValue) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  BeanPredicate beanPredicate = getEqualPredicate(beanPropertyName, beanPropertyValue);
	  Collection<T> selectedList = selectRejected(inputCollection, beanPredicate);
	  return selectedList;
	 }
	 /**
	  * Modifies ValueObject in Collection
	  * 
	  * @param <T>
	  * @param list
	  *            List of ValueObjects
	  * @param beanPropertyName
	  *            PropertyName of ValueObject
	  * @param originalValue
	  *            Original Value
	  * @param valueToBeChanged
	  * @throws ImproperUsageException
	  * @return
	  */
	 public static <T> Collection<T> modifyObjectsFromCollection(Collection<T> inputCollection,
	   String beanPropertyName, Object originalValue, Object valueToBeChanged) {
	  //assertNotNull("Collection cannot be null ", inputCollection);
	  BeanPredicate beanPredicate = getEqualPredicate(beanPropertyName, originalValue);
	  Collection<T> selectedList = select(inputCollection, beanPredicate);
	  try {
	   for (T t : selectedList) {
	    BeanUtils.setProperty(t, beanPropertyName, valueToBeChanged);
	   }
	  }
	  catch (Exception e) {
	   log.error("Exception in CollectionUtilsExt.modifyCollection ", e);
	   //throw new ImproperUsageException("Exception in CollectionUtilsExt.modifyCollection", e);
	  }
	  return selectedList;
	 }
	 /**
	  * Counts the number of elements in the input collection that match the beanPropertyName with value
	  * specified in beanPropertyValue.
	  * <p>
	  * A <code>null</code> collection or predicate matches no elements.
	  * 
	  * @param inputCollection
	  *            the collection to get the input from, may be null
	  * @param beanPropertyNames
	  *            - String array of bean properties names
	  * @param beanPropertyValues
	  *            - Object array of values corresponding to bean properties in beanPropertyName
	  * @return the number of matches for the predicate in the collection
	  */
	 public static int countMatches(Collection<?> inputCollection, String[] beanPropertyNames,
	   String[] beanPropertyValues) {
	  int matches = 0;
	  if (!ArrayUtils.isEmpty(beanPropertyNames) && !ArrayUtils.isEmpty(beanPropertyValues)) {
	  // assertEquals("Length of beanPropertyNames and beanPropertyValues are mismatching ", beanPropertyNames.length, beanPropertyValues.length);
	   Predicate[] predicateArray = new Predicate[beanPropertyNames.length];
	   for (int i = 0; i < beanPropertyNames.length; i++) {
	    if (beanPropertyValues[i] != null) {
	     predicateArray[i] = getEqualPredicate(beanPropertyNames[i], beanPropertyValues[i]);
	    }
	    else {
	     predicateArray[i] = new BeanPredicate(beanPropertyNames[i], PredicateUtils.nullPredicate());
	    }
	   }
	   matches = countMatches(inputCollection, PredicateUtils.allPredicate(predicateArray));
	  }
	  return matches;
	 }
	 /**
	  * Debug the collection and appends output to Log with debug level
	  * @param inputCollection
	  */
	 void debugCollection(Collection<?> inputCollection) {
	  if (CollectionUtils.isNotEmpty(inputCollection)) {
	   for (Object t : inputCollection) {
	    log.debug("[ " + ToStringBuilder.reflectionToString(t) + " ]");
	   }
	  }
	 }
	 
	 /**
	  * Returns the reverse iterator based on {@link List} passed 
	  * Order of elements in orginal collections won't get changed after the calling of reverseIterator(...)
	  * @param <T>
	  * @param inputCollection
	  * @return
	  */
	 <T> Iterator<T> reverseIterator(List<T> inputCollection)
	 {
	  //assertNotNull("Input List should not be null ", inputCollection);
	  ReverseListIterator reverseListIterator  = new ReverseListIterator(inputCollection);
	  return reverseListIterator;
	 }
	 
	 public static Integer size(Collection collection) {
		return collection == null ? null : collection.size();
	 }

	 public static <T, L extends Collection<T>> L emptyIfNull(L collection) {
		return collection == null ? (L) Collections.<T>emptyList() : collection;
	 }
	 
	 public static <T> T guaranteeOne(Collection<T> collection) {
		if(collection == null || collection.isEmpty()) {
			// throw new Cust360RuntimeException("Collection is null or empty: " + collection);
			throw new  RuntimeException("Collection is null or empty: " + collection);
		}

		return collection.iterator().next();
	}
}