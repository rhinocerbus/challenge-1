# challenge-1
### Description of the problem and solution.
Task was to pull data from demo API endpoint and display in RecyclerView - time limit of ~an hour. Ended up using Retrofit+RxJava+GSON for making the the request & parsing the data to POJOs, standard recycler handling with some butterknife to reduce view inflation boilerplate, glide for image loading for the icons.

### Reasoning behind your technical choices. Trade-offs you might have made, anything you left out, or what you might do differently if you were to spend additional time on the project.

Retrofit+RxJava - used due to familiarity with setting up API's and making requests in background threads, could've used kotlin coroutines but would've needed to do some reading first and came in blind.  

GSON - could've used more manual, annotation-based JSON deserialization, or another library like moshi, but this seemed fine & faster for the smaller timeframe.

Glide - also used because most familiar, and picasso/UIL are dead, don't see a reason to look at new ones like fresco.

Burned some time chasing down why the nested Venue objects were seemingly null coming out of the deserializer, hit the endpoint with postman, saw they were just empty, neat! Android studio also still leaves some obstacles in getting a proper new kotlin project setup without issue.

#### Things I would've liked to do with more time:
-setup better organization in general, data classes in their own packages and not glommed together into the service class file

-apply some better code patterns, mvvm/mvc/mvp or something, just did it fast & loose

-better general design, proper handling of the missing venue data, prettier loading/error states (actually there is no error state - so just having one at all)

-better tests

-setup preferred master/dev/feature branching but that seemed silly for the given task - I do favor good branching strategies!
