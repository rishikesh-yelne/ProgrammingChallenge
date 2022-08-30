export interface IMovementRecord {
    companyName: string;
    species: string;
    reason: string;
    movedCount: number;
    startDate: Date;
    originPremiseId: string;
    destinationPremiseId: string;
}