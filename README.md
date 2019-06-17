# Hard Drive Failure Prediction using Machine Learning Methods

## ABSTRACT

Data centers can largely benefit from a service that employs data mining to predict hard
drive failures. Although hard drive failures are rare, they are costly occurrences. Failures
in hard drives could result in temporary system unavailability and/or data loss. Hard drive
manufacturers use Self-Monitoring and Reporting Technology (SMART) attributes
collected during normal operations to predict failures. These SMART attributes report
daily diagnostics of hard drives such as read/write error rates, spin retry count, power
cycle count, etc. We used publicly available data from Backblaze, who started recording
the stats of a large number of hard drives (~47000) from their own data center. In this
project, we analyze and compare the performance of various machine learning algorithms
(Linear Regression, Decision Tree, AdaBoost, XGBoost, Gradient Boosting and k-
Nearest Neighbors) when used to predict hard drive failures using Backblaze data in the
year 2018.

## INTRODUCTION

In this burgeoning digital age, data is being created at an astounding rate. With storage
media capacity increasing and data storage costs plummeting, businesses are now
collecting data, both trivial and critical, in hopes that it may someday be of value. As a
result, data centers are expanding, and hard disk drives are their dominant storage
technology. It is an increasing challenge to maintain storage system reliability since
manual monitoring is far from practical considering the size of the average data center
today.

It appears to be useful if a model can be developed to predict hard drive failures and then
the data center operators might use the prediction result to improve system reliability.
There are some challenges which have to addressed in using this approach to solve this
business problem. First, hard drives are highly reliable devices, implying that their failures
are rare events. This would mean that the dataset used to train models is going to be
skewed with a high ratio of healthy to unhealthy hard drives. This is likely to affect a
model’s performance as there may not be much of a pattern that can distinguish the two
classes of hard drives. Second, since there are a few thousand hard drives in a data
center, the dataset is quite large, resulting in high computational cost in model training.
Third, it is important to keep in mind that it is imperative that the false positive rate is low
upon using a model. Here, a false positive is a healthy hard drive being classified as
unhealthy.

The subsequent subsections discuss the project in detail. The next two subsections involve details
about the dataset used and how the predictor variables were chosen to be used in model
training. 

The various models used to solve the problem and their respective performance
metrics are discussed in subsection "". 

In subsection "  ", an overview of the generalized model
performance and the return on investment for the data center is provided. 

Subsection 6 talks about how our proposed solution can be deployed in the real world.


## DATA UNDERSTANDING

In this project, we used hard drive data made publicly available by Backblaze, an online
backup and cloud storage provider. Backblaze provides a daily snapshot of each
operational hard drive in their data center from 2013 to Q1 of 2019. The daily snapshot
reports a hard drive’s health diagnostics as 90 SMART attributes, both raw and
normalized values. For the purpose of this project, we have resorted to using the data
from 2018. As a result, the dataset we chose to work with had approximately 33 million
rows and 105 columns.
The normalized SMART values are vendor specific and since the Backblaze data center
has hard drives from 4 different manufacturers (Toshiba, Seagate, Western Digital and
HGST), we only consider the raw data columns [1]. Furthermore, each manufacturer
supplies different hard drive models to the data center. In order to have consistency in
the attributes reported, we decided it be best to work with one particular model by a
manufacturer. This also greatly reduced the size of our dataset. How we came to choose
the model and manufacturer is discussed in Chapter 3. After an extensive literature
survey, we were able to deduce that not SMART attributes were predictive of failure.
The attributes that were initially considered to work with are listed in Table 1.

After picking the above 14 features to work with based on our readings, we built models
to predict failures. However, the results weren’t too impressive. So, we decided to further
analyze the features to check which of them, if any, showed large variance in unhealthy
hard drives when compared to healthy hard drives. Out of 24,432 hard drives in the
dataset, 121 hard drives failed in 2018.


It was observed that most of them followed the trend for SMART values 12, 196, 198 and
201 as shown in Fig.1 (a) and (b).
