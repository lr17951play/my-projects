from kafka import KafkaConsumer
import time

consumer = KafkaConsumer(group_id='cws-alert-1', bootstrap_servers=['10.192.30.181:9092'], auto_offset_reset='earliest')
consumer.subscribe(topics=(['AMRULE', 'AMMODEL']))

index = 0
while False:
    msg = consumer.poll(timeout_ms=5, max_records=10)  # 从kafka获取消息
    print(msg)
    time.sleep(2)
    index += 1
    print('--------poll index is %s----------' % index)
