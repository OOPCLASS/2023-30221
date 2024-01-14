### Requirements

1. Implement `sort` method in `ObjectsSorter` such that you can further use it to sort an array of `Comparable` objects.

- Implement `compareTo` method in Student & Teacher class
- Students should be sorted by `grades`, while teachers should be sorted by `numberOfStudents`
- In case of equal grades or number of students, sort by `name`

2. Implement 2 types of `StorageService`

- `FileStorageService` should read/write data from/to a file that contains the data structured as you wish
- `DbStorageService` should read/write data from/to a database (if this seems to had to implement consider an alternative solution of `InMemoryStorageService`)
- `InMemoryStorageService` should read/write data from/to a `List` of objects