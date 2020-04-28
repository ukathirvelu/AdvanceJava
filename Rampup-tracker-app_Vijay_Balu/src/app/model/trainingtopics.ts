import { TrainingDetails } from './trainingdetails';

export interface TrainingTopics {
    id: number;
    topicName: string;
    description: string;
    startDate: Date;
    endDate: Date;
    trainingDetails: TrainingDetails;
}
