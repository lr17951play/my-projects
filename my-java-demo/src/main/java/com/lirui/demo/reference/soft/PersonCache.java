package com.lirui.demo.reference.soft;

import com.lirui.demo.reference.Person;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * @author Ryan
 */
public class PersonCache {

    private static final String LOCK = "LOCK";

    private static volatile PersonCache cache;

    private Hashtable<Integer, PersonRef> personRefs;

    private ReferenceQueue<Person> q;

    public Person getPerson(int id) {
        Person person;
        if (personRefs.containsKey(id)) {
            person = personRefs.get(id).get();
        } else {
            person = new Person(id);
            cachePerson(person);
        }
        return person;
    }

    private void cachePerson(Person person) {
        cleanExpired();
        personRefs.put(person.getId(), new PersonRef(person, q));
    }

    private void cleanExpired() {
        PersonRef ref;
        while ((ref = (PersonRef) q.poll()) != null) {
            personRefs.remove(ref._id);
        }
    }

    private class PersonRef extends SoftReference<Person> {

        private Integer _id;

        public PersonRef(Person person, ReferenceQueue<? super Person> q) {
            super(person, q);
            _id = person.getId();
        }
    }

    public static PersonCache getInstance() {
        if (cache == null) {
            synchronized (LOCK) {
                if (cache == null) {
                    cache = new PersonCache();
                }
            }
        }
        return cache;
    }

    public PersonCache() {
        this.personRefs = new Hashtable<>();
        this.q = new ReferenceQueue<>();
    }
}
